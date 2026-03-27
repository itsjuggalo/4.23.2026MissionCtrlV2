package com.revenuecat.purchases.utils;

import B5.k;
import U6.h;
import U6.o;
import U6.r;
import com.amazon.a.a.o.c.a.b;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.utils.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2470H;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003BG\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0016\u001a\u00020\u00112\u001a\u0010\u0015\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014\u0012\u0004\u0012\u00020\u00110\b¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0019\u001a\u00020\u00112\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0014\u0012\u0004\u0012\u00020\u00110\b¢\u0006\u0004\b\u0019\u0010\u0017J\u0015\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010 R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010!R\"\u0010\t\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\"R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\"¨\u0006#"}, d2 = {"Lcom/revenuecat/purchases/utils/EventsFileHelper;", "Lcom/revenuecat/purchases/utils/Event;", "T", "", "Lcom/revenuecat/purchases/common/FileHelper;", "fileHelper", "", "filePath", "Lkotlin/Function1;", "eventSerializer", "eventDeserializer", "<init>", "(Lcom/revenuecat/purchases/common/FileHelper;Ljava/lang/String;LB5/k;LB5/k;)V", "string", "mapToEvent", "(Ljava/lang/String;)Lcom/revenuecat/purchases/utils/Event;", "event", "Lo5/H;", "appendEvent", "(Lcom/revenuecat/purchases/utils/Event;)V", "LU6/h;", "block", "readFile", "(LB5/k;)V", "Lorg/json/JSONObject;", "readFileAsJson", "", "eventsToDeleteCount", "clear", "(I)V", "deleteFile", "()V", "Lcom/revenuecat/purchases/common/FileHelper;", "Ljava/lang/String;", "LB5/k;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public class EventsFileHelper<T extends Event> {
    private final k eventDeserializer;
    private final k eventSerializer;
    private final FileHelper fileHelper;
    private final String filePath;

    /* JADX INFO: renamed from: com.revenuecat.purchases.utils.EventsFileHelper$readFile$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/revenuecat/purchases/utils/Event;", "T", "LU6/h;", "", "sequence", "Lo5/H;", "invoke", "(LU6/h;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass1 extends AbstractC2306v implements k {
        final /* synthetic */ k $block;
        final /* synthetic */ EventsFileHelper<T> this$0;

        /* JADX INFO: renamed from: com.revenuecat.purchases.utils.EventsFileHelper$readFile$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "T", "Lcom/revenuecat/purchases/utils/Event;", "line", "", "invoke", "(Ljava/lang/String;)Lcom/revenuecat/purchases/utils/Event;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class C02811 extends AbstractC2306v implements k {
            final /* synthetic */ EventsFileHelper<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02811(EventsFileHelper<T> eventsFileHelper) {
                super(1);
                this.this$0 = eventsFileHelper;
            }

            @Override // B5.k
            public final T invoke(String line) {
                AbstractC2304t.f(line, "line");
                return (T) this.this$0.mapToEvent(line);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(k kVar, EventsFileHelper<T> eventsFileHelper) {
            super(1);
            this.$block = kVar;
            this.this$0 = eventsFileHelper;
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((h) obj);
            return C2470H.f21956a;
        }

        public final void invoke(h sequence) {
            AbstractC2304t.f(sequence, "sequence");
            this.$block.invoke(r.B(sequence, new C02811(this.this$0)));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.utils.EventsFileHelper$readFileAsJson$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/revenuecat/purchases/utils/Event;", "T", "LU6/h;", "", "sequence", "Lo5/H;", "invoke", "(LU6/h;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class C16051 extends AbstractC2306v implements k {
        final /* synthetic */ k $block;

        /* JADX INFO: renamed from: com.revenuecat.purchases.utils.EventsFileHelper$readFileAsJson$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "T", "Lcom/revenuecat/purchases/utils/Event;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class C02821 extends AbstractC2306v implements k {
            public static final C02821 INSTANCE = new C02821();

            public C02821() {
                super(1);
            }

            @Override // B5.k
            public final JSONObject invoke(String it) {
                AbstractC2304t.f(it, "it");
                return new JSONObject(it);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16051(k kVar) {
            super(1);
            this.$block = kVar;
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((h) obj);
            return C2470H.f21956a;
        }

        public final void invoke(h sequence) {
            AbstractC2304t.f(sequence, "sequence");
            this.$block.invoke(r.B(sequence, C02821.INSTANCE));
        }
    }

    public EventsFileHelper(FileHelper fileHelper, String filePath, k kVar, k kVar2) {
        AbstractC2304t.f(fileHelper, "fileHelper");
        AbstractC2304t.f(filePath, "filePath");
        this.fileHelper = fileHelper;
        this.filePath = filePath;
        this.eventSerializer = kVar;
        this.eventDeserializer = kVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T mapToEvent(String string) {
        LogHandler currentLogHandler;
        StringBuilder sb;
        k kVar = this.eventDeserializer;
        if (kVar == null) {
            return null;
        }
        try {
            return (T) kVar.invoke(string);
        } catch (SerializationException e8) {
            e = e8;
            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            sb = new StringBuilder();
            sb.append("Error parsing event from file: ");
            sb.append(string);
            currentLogHandler.e("[Purchases] - ERROR", sb.toString(), e);
            return null;
        } catch (IllegalArgumentException e9) {
            e = e9;
            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            sb = new StringBuilder();
            sb.append("Error parsing event from file: ");
            sb.append(string);
            currentLogHandler.e("[Purchases] - ERROR", sb.toString(), e);
            return null;
        }
    }

    public final synchronized void appendEvent(T event) {
        String string;
        try {
            AbstractC2304t.f(event, "event");
            FileHelper fileHelper = this.fileHelper;
            String str = this.filePath;
            StringBuilder sb = new StringBuilder();
            k kVar = this.eventSerializer;
            if (kVar == null || (string = (String) kVar.invoke(event)) == null) {
                string = event.toString();
            }
            sb.append(string);
            sb.append('\n');
            fileHelper.appendToFile(str, sb.toString());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void clear(int eventsToDeleteCount) {
        this.fileHelper.removeFirstLinesFromFile(this.filePath, eventsToDeleteCount);
    }

    public final synchronized void deleteFile() {
        if (!this.fileHelper.deleteFile(this.filePath)) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.v("[Purchases] - " + logLevel.name(), "Failed to delete events file in " + this.filePath + b.f14112a);
            }
        }
    }

    public final synchronized void readFile(k block) {
        try {
            AbstractC2304t.f(block, "block");
            if (this.eventDeserializer == null || this.fileHelper.fileIsEmpty(this.filePath)) {
                block.invoke(o.g());
            } else {
                this.fileHelper.readFilePerLines(this.filePath, new AnonymousClass1(block, this));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void readFileAsJson(k block) {
        try {
            AbstractC2304t.f(block, "block");
            if (this.fileHelper.fileIsEmpty(this.filePath)) {
                block.invoke(o.g());
            } else {
                this.fileHelper.readFilePerLines(this.filePath, new C16051(block));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public /* synthetic */ EventsFileHelper(FileHelper fileHelper, String str, k kVar, k kVar2, int i8, AbstractC2296k abstractC2296k) {
        this(fileHelper, str, (i8 & 4) != 0 ? null : kVar, (i8 & 8) != 0 ? null : kVar2);
    }
}
