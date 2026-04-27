package y1;

import y1.s;

/* JADX INFO: loaded from: classes.dex */
public final class i extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f24352a;

    public static final class b extends s.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public r f24353a;

        @Override // y1.s.a
        public s a() {
            return new i(this.f24353a);
        }

        @Override // y1.s.a
        public s.a b(r rVar) {
            this.f24353a = rVar;
            return this;
        }
    }

    public i(r rVar) {
        this.f24352a = rVar;
    }

    @Override // y1.s
    public r b() {
        return this.f24352a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        r rVar = this.f24352a;
        r rVarB = ((s) obj).b();
        return rVar == null ? rVarB == null : rVar.equals(rVarB);
    }

    public int hashCode() {
        r rVar = this.f24352a;
        return (rVar == null ? 0 : rVar.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f24352a + "}";
    }
}
