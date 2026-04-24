package io.flutter.embedding.engine.dart;

import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.util.TraceSection;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
class DartMessenger implements BinaryMessenger, PlatformMessageHandler {
    private static final String TAG = "DartMessenger";
    private Map<String, List<BufferedMessageInfo>> bufferedMessages;
    private WeakHashMap<BinaryMessenger.TaskQueue, DartMessengerTaskQueue> createdTaskQueues;
    private final AtomicBoolean enableBufferingIncomingMessages;
    private final FlutterJNI flutterJNI;
    private final Object handlersLock;
    private final Map<String, HandlerInfo> messageHandlers;
    private int nextReplyId;
    private final Map<Integer, BinaryMessenger.BinaryReply> pendingReplies;
    private final DartMessengerTaskQueue platformTaskQueue;
    private TaskQueueFactory taskQueueFactory;

    public static class BufferedMessageInfo {
        public final ByteBuffer message;
        long messageData;
        int replyId;

        public BufferedMessageInfo(ByteBuffer byteBuffer, int i4, long j4) {
            this.message = byteBuffer;
            this.replyId = i4;
            this.messageData = j4;
        }
    }

    public static class ConcurrentTaskQueue implements DartMessengerTaskQueue {
        private final ExecutorService executor;

        public ConcurrentTaskQueue(ExecutorService executorService) {
            this.executor = executorService;
        }

        @Override // io.flutter.embedding.engine.dart.DartMessenger.DartMessengerTaskQueue
        public void dispatch(Runnable runnable) {
            this.executor.execute(runnable);
        }
    }

    public interface DartMessengerTaskQueue {
        void dispatch(Runnable runnable);
    }

    public static class DefaultTaskQueueFactory implements TaskQueueFactory {
        ExecutorService executorService = FlutterInjector.instance().executorService();

        @Override // io.flutter.embedding.engine.dart.DartMessenger.TaskQueueFactory
        public DartMessengerTaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
            return taskQueueOptions.getIsSerial() ? new SerialTaskQueue(this.executorService) : new ConcurrentTaskQueue(this.executorService);
        }
    }

    public static class HandlerInfo {
        public final BinaryMessenger.BinaryMessageHandler handler;
        public final DartMessengerTaskQueue taskQueue;

        public HandlerInfo(BinaryMessenger.BinaryMessageHandler binaryMessageHandler, DartMessengerTaskQueue dartMessengerTaskQueue) {
            this.handler = binaryMessageHandler;
            this.taskQueue = dartMessengerTaskQueue;
        }
    }

    public static class Reply implements BinaryMessenger.BinaryReply {
        private final AtomicBoolean done = new AtomicBoolean(false);
        private final FlutterJNI flutterJNI;
        private final int replyId;

        public Reply(FlutterJNI flutterJNI, int i4) {
            this.flutterJNI = flutterJNI;
            this.replyId = i4;
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
        public void reply(ByteBuffer byteBuffer) throws Throwable {
            if (this.done.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            }
            if (byteBuffer == null) {
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(this.replyId);
            } else {
                this.flutterJNI.invokePlatformMessageResponseCallback(this.replyId, byteBuffer, byteBuffer.position());
            }
        }
    }

    public static class SerialTaskQueue implements DartMessengerTaskQueue {
        private final ExecutorService executor;
        private final ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean isRunning = new AtomicBoolean(false);

        public SerialTaskQueue(ExecutorService executorService) {
            this.executor = executorService;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void flush() {
            if (this.isRunning.compareAndSet(false, true)) {
                try {
                    Runnable runnablePoll = this.queue.poll();
                    if (runnablePoll != null) {
                        runnablePoll.run();
                    }
                } finally {
                    this.isRunning.set(false);
                    if (!this.queue.isEmpty()) {
                        this.executor.execute(new Runnable() { // from class: io.flutter.embedding.engine.dart.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f12277a.flush();
                            }
                        });
                    }
                }
            }
        }

        @Override // io.flutter.embedding.engine.dart.DartMessenger.DartMessengerTaskQueue
        public void dispatch(Runnable runnable) {
            this.queue.add(runnable);
            this.executor.execute(new Runnable() { // from class: io.flutter.embedding.engine.dart.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12276a.flush();
                }
            });
        }
    }

    public interface TaskQueueFactory {
        DartMessengerTaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions);
    }

    public static class TaskQueueToken implements BinaryMessenger.TaskQueue {
        private TaskQueueToken() {
        }
    }

    public DartMessenger(FlutterJNI flutterJNI, TaskQueueFactory taskQueueFactory) {
        this.messageHandlers = new HashMap();
        this.bufferedMessages = new HashMap();
        this.handlersLock = new Object();
        this.enableBufferingIncomingMessages = new AtomicBoolean(false);
        this.pendingReplies = new HashMap();
        this.nextReplyId = 1;
        this.platformTaskQueue = new PlatformTaskQueue();
        this.createdTaskQueues = new WeakHashMap<>();
        this.flutterJNI = flutterJNI;
        this.taskQueueFactory = taskQueueFactory;
    }

    public static /* synthetic */ void a(DartMessenger dartMessenger, String str, int i4, HandlerInfo handlerInfo, ByteBuffer byteBuffer, long j4) {
        dartMessenger.getClass();
        TraceSection.endAsyncSection("PlatformChannel ScheduleHandler on " + str, i4);
        try {
            TraceSection traceSectionScoped = TraceSection.scoped("DartMessenger#handleMessageFromDart on " + str);
            try {
                dartMessenger.invokeHandler(handlerInfo, byteBuffer, i4);
                if (byteBuffer != null && byteBuffer.isDirect()) {
                    byteBuffer.limit(0);
                }
                if (traceSectionScoped != null) {
                    traceSectionScoped.close();
                }
            } finally {
            }
        } finally {
            dartMessenger.flutterJNI.cleanupMessageData(j4);
        }
    }

    private void dispatchMessageToQueue(final String str, final HandlerInfo handlerInfo, final ByteBuffer byteBuffer, final int i4, final long j4) {
        DartMessengerTaskQueue dartMessengerTaskQueue = handlerInfo != null ? handlerInfo.taskQueue : null;
        TraceSection.beginAsyncSection("PlatformChannel ScheduleHandler on " + str, i4);
        Runnable runnable = new Runnable() { // from class: io.flutter.embedding.engine.dart.a
            @Override // java.lang.Runnable
            public final void run() {
                DartMessenger.a(this.f12270a, str, i4, handlerInfo, byteBuffer, j4);
            }
        };
        if (dartMessengerTaskQueue == null) {
            dartMessengerTaskQueue = this.platformTaskQueue;
        }
        dartMessengerTaskQueue.dispatch(runnable);
    }

    private static void handleError(Error error) {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread.getUncaughtExceptionHandler() == null) {
            throw error;
        }
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, error);
    }

    private void invokeHandler(HandlerInfo handlerInfo, ByteBuffer byteBuffer, int i4) {
        if (handlerInfo == null) {
            Log.v(TAG, "No registered handler for message. Responding to Dart with empty reply message.");
            this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i4);
            return;
        }
        try {
            Log.v(TAG, "Deferring to registered handler to process message.");
            handlerInfo.handler.onMessage(byteBuffer, new Reply(this.flutterJNI, i4));
        } catch (Error e4) {
            handleError(e4);
        } catch (Exception e5) {
            Log.e(TAG, "Uncaught exception in binary message listener", e5);
            this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i4);
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void disableBufferingIncomingMessages() {
        Map<String, List<BufferedMessageInfo>> map;
        synchronized (this.handlersLock) {
            this.enableBufferingIncomingMessages.set(false);
            map = this.bufferedMessages;
            this.bufferedMessages = new HashMap();
        }
        for (Map.Entry<String, List<BufferedMessageInfo>> entry : map.entrySet()) {
            for (BufferedMessageInfo bufferedMessageInfo : entry.getValue()) {
                dispatchMessageToQueue(entry.getKey(), null, bufferedMessageInfo.message, bufferedMessageInfo.replyId, bufferedMessageInfo.messageData);
            }
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void enableBufferingIncomingMessages() {
        this.enableBufferingIncomingMessages.set(true);
    }

    public int getPendingChannelResponseCount() {
        return this.pendingReplies.size();
    }

    @Override // io.flutter.embedding.engine.dart.PlatformMessageHandler
    public void handleMessageFromDart(String str, ByteBuffer byteBuffer, int i4, long j4) {
        HandlerInfo handlerInfo;
        boolean z4;
        Log.v(TAG, "Received message from Dart over channel '" + str + "'");
        synchronized (this.handlersLock) {
            try {
                handlerInfo = this.messageHandlers.get(str);
                z4 = this.enableBufferingIncomingMessages.get() && handlerInfo == null;
                if (z4) {
                    if (!this.bufferedMessages.containsKey(str)) {
                        this.bufferedMessages.put(str, new LinkedList());
                    }
                    this.bufferedMessages.get(str).add(new BufferedMessageInfo(byteBuffer, i4, j4));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z4) {
            return;
        }
        dispatchMessageToQueue(str, handlerInfo, byteBuffer, i4, j4);
    }

    @Override // io.flutter.embedding.engine.dart.PlatformMessageHandler
    public void handlePlatformMessageResponse(int i4, ByteBuffer byteBuffer) {
        Log.v(TAG, "Received message reply from Dart.");
        BinaryMessenger.BinaryReply binaryReplyRemove = this.pendingReplies.remove(Integer.valueOf(i4));
        if (binaryReplyRemove != null) {
            try {
                Log.v(TAG, "Invoking registered callback for reply from Dart.");
                binaryReplyRemove.reply(byteBuffer);
                if (byteBuffer == null || !byteBuffer.isDirect()) {
                    return;
                }
                byteBuffer.limit(0);
            } catch (Error e4) {
                handleError(e4);
            } catch (Exception e5) {
                Log.e(TAG, "Uncaught exception in binary message reply handler", e5);
            }
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        DartMessengerTaskQueue dartMessengerTaskQueueMakeBackgroundTaskQueue = this.taskQueueFactory.makeBackgroundTaskQueue(taskQueueOptions);
        TaskQueueToken taskQueueToken = new TaskQueueToken();
        this.createdTaskQueues.put(taskQueueToken, dartMessengerTaskQueueMakeBackgroundTaskQueue);
        return taskQueueToken;
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void send(String str, ByteBuffer byteBuffer) {
        Log.v(TAG, "Sending message over channel '" + str + "'");
        send(str, byteBuffer, null);
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        setMessageHandler(str, binaryMessageHandler, null);
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler, BinaryMessenger.TaskQueue taskQueue) {
        DartMessengerTaskQueue dartMessengerTaskQueue;
        if (binaryMessageHandler == null) {
            Log.v(TAG, "Removing handler for channel '" + str + "'");
            synchronized (this.handlersLock) {
                this.messageHandlers.remove(str);
            }
            return;
        }
        if (taskQueue != null) {
            dartMessengerTaskQueue = this.createdTaskQueues.get(taskQueue);
            if (dartMessengerTaskQueue == null) {
                throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
            }
        } else {
            dartMessengerTaskQueue = null;
        }
        Log.v(TAG, "Setting handler for channel '" + str + "'");
        synchronized (this.handlersLock) {
            try {
                this.messageHandlers.put(str, new HandlerInfo(binaryMessageHandler, dartMessengerTaskQueue));
                List<BufferedMessageInfo> listRemove = this.bufferedMessages.remove(str);
                if (listRemove == null) {
                    return;
                }
                for (BufferedMessageInfo bufferedMessageInfo : listRemove) {
                    dispatchMessageToQueue(str, this.messageHandlers.get(str), bufferedMessageInfo.message, bufferedMessageInfo.replyId, bufferedMessageInfo.messageData);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        TraceSection traceSectionScoped = TraceSection.scoped("DartMessenger#send on " + str);
        try {
            Log.v(TAG, "Sending message with callback over channel '" + str + "'");
            int i4 = this.nextReplyId;
            this.nextReplyId = i4 + 1;
            if (binaryReply != null) {
                this.pendingReplies.put(Integer.valueOf(i4), binaryReply);
            }
            if (byteBuffer == null) {
                this.flutterJNI.dispatchEmptyPlatformMessage(str, i4);
            } else {
                this.flutterJNI.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i4);
            }
            if (traceSectionScoped != null) {
                traceSectionScoped.close();
            }
        } catch (Throwable th) {
            if (traceSectionScoped != null) {
                try {
                    traceSectionScoped.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public DartMessenger(FlutterJNI flutterJNI) {
        this(flutterJNI, new DefaultTaskQueueFactory());
    }
}
