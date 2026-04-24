package com.revenuecat.purchases.utils;

import W2.E;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.utils.Event;
import i3.k;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import org.json.JSONObject;
import q3.e;
import q3.j;
import q3.l;

/* JADX INFO: loaded from: classes3.dex */
public class EventsFileHelper<T extends Event> {
    private final k eventDeserializer;
    private final k eventSerializer;
    private final FileHelper fileHelper;
    private final String filePath;

    /* JADX INFO: renamed from: com.revenuecat.purchases.utils.EventsFileHelper$readFile$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        final /* synthetic */ k $block;
        final /* synthetic */ EventsFileHelper<T> this$0;

        /* JADX INFO: renamed from: com.revenuecat.purchases.utils.EventsFileHelper$readFile$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01791 extends s implements k {
            final /* synthetic */ EventsFileHelper<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01791(EventsFileHelper<T> eventsFileHelper) {
                super(1);
                this.this$0 = eventsFileHelper;
            }

            @Override // i3.k
            public final T invoke(String line) {
                r.f(line, "line");
                return (T) this.this$0.mapToEvent(line);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(k kVar, EventsFileHelper<T> eventsFileHelper) {
            super(1);
            this.$block = kVar;
            this.this$0 = eventsFileHelper;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((e) obj);
            return E.f5463a;
        }

        public final void invoke(e sequence) {
            r.f(sequence, "sequence");
            this.$block.invoke(l.i(sequence, new C01791(this.this$0)));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.utils.EventsFileHelper$readFileAsJson$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12041 extends s implements k {
        final /* synthetic */ k $block;

        /* JADX INFO: renamed from: com.revenuecat.purchases.utils.EventsFileHelper$readFileAsJson$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01801 extends s implements k {
            public static final C01801 INSTANCE = new C01801();

            public C01801() {
                super(1);
            }

            @Override // i3.k
            public final JSONObject invoke(String it) {
                r.f(it, "it");
                return new JSONObject(it);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12041(k kVar) {
            super(1);
            this.$block = kVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((e) obj);
            return E.f5463a;
        }

        public final void invoke(e sequence) {
            r.f(sequence, "sequence");
            this.$block.invoke(l.i(sequence, C01801.INSTANCE));
        }
    }

    public EventsFileHelper(FileHelper fileHelper, String filePath, k kVar, k kVar2) {
        r.f(fileHelper, "fileHelper");
        r.f(filePath, "filePath");
        this.fileHelper = fileHelper;
        this.filePath = filePath;
        this.eventSerializer = kVar;
        this.eventDeserializer = kVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T mapToEvent(String str) {
        k kVar = this.eventDeserializer;
        if (kVar == null) {
            return null;
        }
        try {
            return (T) kVar.invoke(str);
        } catch (SerializationException e4) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing event from file: " + str, e4);
            return null;
        } catch (IllegalArgumentException e5) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing event from file: " + str, e5);
            return null;
        }
    }

    public final synchronized void appendEvent(T event) {
        String string;
        try {
            r.f(event, "event");
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

    public final synchronized void clear(int i4) {
        this.fileHelper.removeFirstLinesFromFile(this.filePath, i4);
    }

    public final synchronized void deleteFile() {
        if (!this.fileHelper.deleteFile(this.filePath)) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.v("[Purchases] - " + logLevel.name(), "Failed to delete events file in " + this.filePath + com.amazon.a.a.o.c.a.b.f8816a);
            }
        }
    }

    public final synchronized void readFile(k block) {
        try {
            r.f(block, "block");
            if (this.eventDeserializer == null || this.fileHelper.fileIsEmpty(this.filePath)) {
                block.invoke(j.e());
            } else {
                this.fileHelper.readFilePerLines(this.filePath, new AnonymousClass1(block, this));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void readFileAsJson(k block) {
        try {
            r.f(block, "block");
            if (this.fileHelper.fileIsEmpty(this.filePath)) {
                block.invoke(j.e());
            } else {
                this.fileHelper.readFilePerLines(this.filePath, new C12041(block));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public /* synthetic */ EventsFileHelper(FileHelper fileHelper, String str, k kVar, k kVar2, int i4, AbstractC1585j abstractC1585j) {
        this(fileHelper, str, (i4 & 4) != 0 ? null : kVar, (i4 & 8) != 0 ? null : kVar2);
    }
}
