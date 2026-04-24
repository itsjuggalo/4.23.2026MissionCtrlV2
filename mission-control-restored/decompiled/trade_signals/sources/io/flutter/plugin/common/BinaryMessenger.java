package io.flutter.plugin.common;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface BinaryMessenger {

    public interface BinaryMessageHandler {
        void onMessage(ByteBuffer byteBuffer, BinaryReply binaryReply);
    }

    public interface BinaryReply {
        void reply(ByteBuffer byteBuffer);
    }

    public interface TaskQueue {
    }

    public static class TaskQueueOptions {
        private boolean isSerial = true;

        public boolean getIsSerial() {
            return this.isSerial;
        }

        public TaskQueueOptions setIsSerial(boolean z7) {
            this.isSerial = z7;
            return this;
        }
    }

    default void disableBufferingIncomingMessages() {
        throw new UnsupportedOperationException("disableBufferingIncomingMessages not implemented.");
    }

    default void enableBufferingIncomingMessages() {
        throw new UnsupportedOperationException("enableBufferingIncomingMessages not implemented.");
    }

    default TaskQueue makeBackgroundTaskQueue() {
        return makeBackgroundTaskQueue(new TaskQueueOptions());
    }

    void send(String str, ByteBuffer byteBuffer);

    void send(String str, ByteBuffer byteBuffer, BinaryReply binaryReply);

    void setMessageHandler(String str, BinaryMessageHandler binaryMessageHandler);

    default void setMessageHandler(String str, BinaryMessageHandler binaryMessageHandler, TaskQueue taskQueue) {
        if (taskQueue != null) {
            throw new UnsupportedOperationException("setMessageHandler called with nonnull taskQueue is not supported.");
        }
        setMessageHandler(str, binaryMessageHandler);
    }

    default TaskQueue makeBackgroundTaskQueue(TaskQueueOptions taskQueueOptions) {
        throw new UnsupportedOperationException("makeBackgroundTaskQueue not implemented.");
    }
}
