package com.revenuecat.purchases.utils;

import E5.E;
import Q5.k;
import Y5.f;
import Y5.m;
import com.amazon.a.a.o.c.a.b;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.utils.Event;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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
        public static final class C02261 extends s implements k {
            final /* synthetic */ EventsFileHelper<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02261(EventsFileHelper<T> eventsFileHelper) {
                super(1);
                this.this$0 = eventsFileHelper;
            }

            @Override // Q5.k
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

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((f) obj);
            return E.f1657a;
        }

        public final void invoke(f sequence) {
            r.f(sequence, "sequence");
            this.$block.invoke(m.j(sequence, new C02261(this.this$0)));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.utils.EventsFileHelper$readFileAsJson$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13821 extends s implements k {
        final /* synthetic */ k $block;

        /* JADX INFO: renamed from: com.revenuecat.purchases.utils.EventsFileHelper$readFileAsJson$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02271 extends s implements k {
            public static final C02271 INSTANCE = new C02271();

            public C02271() {
                super(1);
            }

            @Override // Q5.k
            public final JSONObject invoke(String it) {
                r.f(it, "it");
                return new JSONObject(it);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13821(k kVar) {
            super(1);
            this.$block = kVar;
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((f) obj);
            return E.f1657a;
        }

        public final void invoke(f sequence) {
            r.f(sequence, "sequence");
            this.$block.invoke(m.j(sequence, C02271.INSTANCE));
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
        } catch (SerializationException e7) {
            LogUtilsKt.errorLog("Error parsing event from file: " + str, e7);
            return null;
        } catch (IllegalArgumentException e8) {
            LogUtilsKt.errorLog("Error parsing event from file: " + str, e8);
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

    public final synchronized void clear(int i7) {
        this.fileHelper.removeFirstLinesFromFile(this.filePath, i7);
    }

    public final synchronized void deleteFile() {
        if (!this.fileHelper.deleteFile(this.filePath)) {
            LogUtilsKt.verboseLog("Failed to delete events file in " + this.filePath + b.f10001a);
        }
    }

    public final synchronized void readFile(k block) {
        try {
            r.f(block, "block");
            if (this.eventDeserializer == null || this.fileHelper.fileIsEmpty(this.filePath)) {
                block.invoke(Y5.k.e());
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
                block.invoke(Y5.k.e());
            } else {
                this.fileHelper.readFilePerLines(this.filePath, new C13821(block));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public /* synthetic */ EventsFileHelper(FileHelper fileHelper, String str, k kVar, k kVar2, int i7, AbstractC2148j abstractC2148j) {
        this(fileHelper, str, (i7 & 4) != 0 ? null : kVar, (i7 & 8) != 0 ? null : kVar2);
    }
}
