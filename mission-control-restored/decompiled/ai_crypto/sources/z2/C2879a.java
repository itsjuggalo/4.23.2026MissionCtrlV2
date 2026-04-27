package z2;

import android.graphics.Typeface;

/* JADX INFO: renamed from: z2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2879a extends AbstractC2884f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f26030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0398a f26031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f26032c;

    /* JADX INFO: renamed from: z2.a$a, reason: collision with other inner class name */
    public interface InterfaceC0398a {
        void a(Typeface typeface);
    }

    public C2879a(InterfaceC0398a interfaceC0398a, Typeface typeface) {
        this.f26030a = typeface;
        this.f26031b = interfaceC0398a;
    }

    @Override // z2.AbstractC2884f
    public void a(int i7) {
        d(this.f26030a);
    }

    @Override // z2.AbstractC2884f
    public void b(Typeface typeface, boolean z7) {
        d(typeface);
    }

    public void c() {
        this.f26032c = true;
    }

    public final void d(Typeface typeface) {
        if (this.f26032c) {
            return;
        }
        this.f26031b.a(typeface);
    }
}
