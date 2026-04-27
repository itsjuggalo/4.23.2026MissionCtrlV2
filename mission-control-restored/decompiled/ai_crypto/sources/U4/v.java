package U4;

import V4.j;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.j f5129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f5130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.c f5131c;

    public class a implements j.c {
        public a() {
        }

        @Override // V4.j.c
        public void onMethodCall(V4.i iVar, j.d dVar) {
            String str;
            if (v.this.f5130b == null) {
            }
            str = iVar.f5332a;
            J4.b.f("SensitiveContentChannel", "Received '" + str + "' message.");
            str.hashCode();
            switch (str) {
                case "SensitiveContent.getContentSensitivity":
                    try {
                        dVar.a(Integer.valueOf(v.this.e(v.this.f5130b.b())));
                        break;
                    } catch (IllegalArgumentException | IllegalStateException e7) {
                        dVar.b("error", e7.getMessage(), null);
                        return;
                    }
                    break;
                case "SensitiveContent.setContentSensitivity":
                    try {
                        v.this.f5130b.c(v.this.d(((Integer) iVar.b()).intValue()));
                        break;
                    } catch (IllegalArgumentException | IllegalStateException e8) {
                        dVar.b("error", e8.getMessage(), null);
                        return;
                    }
                    break;
                case "SensitiveContent.isSupported":
                    dVar.a(Boolean.valueOf(v.this.f5130b.a()));
                    break;
                default:
                    J4.b.f("SensitiveContentChannel", "Method " + str + " is not implemented for the SensitiveContentChannel.");
                    dVar.c();
                    break;
            }
        }
    }

    public interface b {
        boolean a();

        int b();

        void c(int i7);
    }

    public v(M4.a aVar) {
        a aVar2 = new a();
        this.f5131c = aVar2;
        V4.j jVar = new V4.j(aVar, "flutter/sensitivecontent", V4.p.f5347b);
        this.f5129a = jVar;
        jVar.e(aVar2);
    }

    public final int d(int i7) {
        if (i7 == 0) {
            return 0;
        }
        if (i7 == 1) {
            return 1;
        }
        if (i7 == 2) {
            return 2;
        }
        throw new IllegalArgumentException("contentSensitivityIndex " + i7 + " not known to the SensitiveContentChannel.");
    }

    public final int e(int i7) {
        if (i7 == 0) {
            return 0;
        }
        int i8 = 1;
        if (i7 != 1) {
            i8 = 2;
            if (i7 != 2) {
                return 3;
            }
        }
        return i8;
    }

    public void f(b bVar) {
        this.f5130b = bVar;
    }
}
