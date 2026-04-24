package com.revenuecat.purchases;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2306v;
import o5.AbstractC2484l;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import o7.A;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/PeriodType;", "", "(Ljava/lang/String;I)V", "NORMAL", "INTRO", "TRIAL", "PREPAID", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum PeriodType {
    NORMAL,
    INTRO,
    TRIAL,
    PREPAID;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final InterfaceC2483k $cachedSerializer$delegate = AbstractC2484l.b(EnumC2486n.f21975b, Companion.AnonymousClass1.INSTANCE);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/PeriodType$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/PeriodType;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* JADX INFO: renamed from: com.revenuecat.purchases.PeriodType$Companion$1, reason: invalid class name */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class AnonymousClass1 extends AbstractC2306v implements Function0 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final k7.b invoke() {
                return A.a("com.revenuecat.purchases.PeriodType", PeriodType.values(), new String[]{"normal", "intro", "trial", "prepaid"}, new Annotation[][]{null, null, null, null}, null);
            }
        }

        private Companion() {
        }

        private final /* synthetic */ k7.b get$cachedSerializer() {
            return (k7.b) PeriodType.$cachedSerializer$delegate.getValue();
        }

        public final k7.b serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }
}
