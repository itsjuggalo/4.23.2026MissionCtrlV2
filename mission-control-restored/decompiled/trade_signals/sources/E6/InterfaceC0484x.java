package E6;

import I6.AbstractC0613d0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: E6.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC0484x {

    /* JADX INFO: renamed from: E6.x$a */
    public static final class a implements InterfaceC0484x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1044a = new a();

        @Override // E6.InterfaceC0484x
        public I6.S a(l6.q proto, String flexibleId, AbstractC0613d0 lowerBound, AbstractC0613d0 upperBound) {
            AbstractC2304t.f(proto, "proto");
            AbstractC2304t.f(flexibleId, "flexibleId");
            AbstractC2304t.f(lowerBound, "lowerBound");
            AbstractC2304t.f(upperBound, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    I6.S a(l6.q qVar, String str, AbstractC0613d0 abstractC0613d0, AbstractC0613d0 abstractC0613d02);
}
