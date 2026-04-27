package W5;

import R5.i0;
import X5.u;
import g6.InterfaceC1839a;
import g6.InterfaceC1840b;
import h6.InterfaceC1903l;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements InterfaceC1840b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f9303a = new l();

    public static final class a implements InterfaceC1839a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u f9304b;

        public a(u javaElement) {
            AbstractC2304t.f(javaElement, "javaElement");
            this.f9304b = javaElement;
        }

        @Override // R5.h0
        public i0 a() {
            i0 NO_SOURCE_FILE = i0.f7250a;
            AbstractC2304t.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
            return NO_SOURCE_FILE;
        }

        @Override // g6.InterfaceC1839a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public u b() {
            return this.f9304b;
        }

        public String toString() {
            return a.class.getName() + ": " + b();
        }
    }

    @Override // g6.InterfaceC1840b
    public InterfaceC1839a a(InterfaceC1903l javaElement) {
        AbstractC2304t.f(javaElement, "javaElement");
        return new a((u) javaElement);
    }
}
