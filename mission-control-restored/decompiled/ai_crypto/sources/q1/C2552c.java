package q1;

import q1.AbstractC2550a;

/* JADX INFO: renamed from: q1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2552c extends AbstractC2550a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f22160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f22165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f22166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f22167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f22168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f22169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f22170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f22171l;

    /* JADX INFO: renamed from: q1.c$b */
    public static final class b extends AbstractC2550a.AbstractC0337a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f22172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f22174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f22175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f22176e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f22177f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f22178g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f22179h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f22180i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f22181j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f22182k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f22183l;

        @Override // q1.AbstractC2550a.AbstractC0337a
        public AbstractC2550a a() {
            return new C2552c(this.f22172a, this.f22173b, this.f22174c, this.f22175d, this.f22176e, this.f22177f, this.f22178g, this.f22179h, this.f22180i, this.f22181j, this.f22182k, this.f22183l);
        }

        @Override // q1.AbstractC2550a.AbstractC0337a
        public AbstractC2550a.AbstractC0337a b(String str) {
            this.f22183l = str;
            return this;
        }

        @Override // q1.AbstractC2550a.AbstractC0337a
        public AbstractC2550a.AbstractC0337a c(String str) {
            this.f22181j = str;
            return this;
        }

        @Override // q1.AbstractC2550a.AbstractC0337a
        public AbstractC2550a.AbstractC0337a d(String str) {
            this.f22175d = str;
            return this;
        }

        @Override // q1.AbstractC2550a.AbstractC0337a
        public AbstractC2550a.AbstractC0337a e(String str) {
            this.f22179h = str;
            return this;
        }

        @Override // q1.AbstractC2550a.AbstractC0337a
        public AbstractC2550a.AbstractC0337a f(String str) {
            this.f22174c = str;
            return this;
        }

        @Override // q1.AbstractC2550a.AbstractC0337a
        public AbstractC2550a.AbstractC0337a g(String str) {
            this.f22180i = str;
            return this;
        }

        @Override // q1.AbstractC2550a.AbstractC0337a
        public AbstractC2550a.AbstractC0337a h(String str) {
            this.f22178g = str;
            return this;
        }

        @Override // q1.AbstractC2550a.AbstractC0337a
        public AbstractC2550a.AbstractC0337a i(String str) {
            this.f22182k = str;
            return this;
        }

        @Override // q1.AbstractC2550a.AbstractC0337a
        public AbstractC2550a.AbstractC0337a j(String str) {
            this.f22173b = str;
            return this;
        }

        @Override // q1.AbstractC2550a.AbstractC0337a
        public AbstractC2550a.AbstractC0337a k(String str) {
            this.f22177f = str;
            return this;
        }

        @Override // q1.AbstractC2550a.AbstractC0337a
        public AbstractC2550a.AbstractC0337a l(String str) {
            this.f22176e = str;
            return this;
        }

        @Override // q1.AbstractC2550a.AbstractC0337a
        public AbstractC2550a.AbstractC0337a m(Integer num) {
            this.f22172a = num;
            return this;
        }
    }

    @Override // q1.AbstractC2550a
    public String b() {
        return this.f22171l;
    }

    @Override // q1.AbstractC2550a
    public String c() {
        return this.f22169j;
    }

    @Override // q1.AbstractC2550a
    public String d() {
        return this.f22163d;
    }

    @Override // q1.AbstractC2550a
    public String e() {
        return this.f22167h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2550a)) {
            return false;
        }
        AbstractC2550a abstractC2550a = (AbstractC2550a) obj;
        Integer num = this.f22160a;
        if (num != null ? num.equals(abstractC2550a.m()) : abstractC2550a.m() == null) {
            String str = this.f22161b;
            if (str != null ? str.equals(abstractC2550a.j()) : abstractC2550a.j() == null) {
                String str2 = this.f22162c;
                if (str2 != null ? str2.equals(abstractC2550a.f()) : abstractC2550a.f() == null) {
                    String str3 = this.f22163d;
                    if (str3 != null ? str3.equals(abstractC2550a.d()) : abstractC2550a.d() == null) {
                        String str4 = this.f22164e;
                        if (str4 != null ? str4.equals(abstractC2550a.l()) : abstractC2550a.l() == null) {
                            String str5 = this.f22165f;
                            if (str5 != null ? str5.equals(abstractC2550a.k()) : abstractC2550a.k() == null) {
                                String str6 = this.f22166g;
                                if (str6 != null ? str6.equals(abstractC2550a.h()) : abstractC2550a.h() == null) {
                                    String str7 = this.f22167h;
                                    if (str7 != null ? str7.equals(abstractC2550a.e()) : abstractC2550a.e() == null) {
                                        String str8 = this.f22168i;
                                        if (str8 != null ? str8.equals(abstractC2550a.g()) : abstractC2550a.g() == null) {
                                            String str9 = this.f22169j;
                                            if (str9 != null ? str9.equals(abstractC2550a.c()) : abstractC2550a.c() == null) {
                                                String str10 = this.f22170k;
                                                if (str10 != null ? str10.equals(abstractC2550a.i()) : abstractC2550a.i() == null) {
                                                    String str11 = this.f22171l;
                                                    if (str11 == null) {
                                                        if (abstractC2550a.b() == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(abstractC2550a.b())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // q1.AbstractC2550a
    public String f() {
        return this.f22162c;
    }

    @Override // q1.AbstractC2550a
    public String g() {
        return this.f22168i;
    }

    @Override // q1.AbstractC2550a
    public String h() {
        return this.f22166g;
    }

    public int hashCode() {
        Integer num = this.f22160a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f22161b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f22162c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f22163d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f22164e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f22165f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f22166g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f22167h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f22168i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f22169j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f22170k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f22171l;
        return iHashCode11 ^ (str11 != null ? str11.hashCode() : 0);
    }

    @Override // q1.AbstractC2550a
    public String i() {
        return this.f22170k;
    }

    @Override // q1.AbstractC2550a
    public String j() {
        return this.f22161b;
    }

    @Override // q1.AbstractC2550a
    public String k() {
        return this.f22165f;
    }

    @Override // q1.AbstractC2550a
    public String l() {
        return this.f22164e;
    }

    @Override // q1.AbstractC2550a
    public Integer m() {
        return this.f22160a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f22160a + ", model=" + this.f22161b + ", hardware=" + this.f22162c + ", device=" + this.f22163d + ", product=" + this.f22164e + ", osBuild=" + this.f22165f + ", manufacturer=" + this.f22166g + ", fingerprint=" + this.f22167h + ", locale=" + this.f22168i + ", country=" + this.f22169j + ", mccMnc=" + this.f22170k + ", applicationBuild=" + this.f22171l + "}";
    }

    public C2552c(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f22160a = num;
        this.f22161b = str;
        this.f22162c = str2;
        this.f22163d = str3;
        this.f22164e = str4;
        this.f22165f = str5;
        this.f22166g = str6;
        this.f22167h = str7;
        this.f22168i = str8;
        this.f22169j = str9;
        this.f22170k = str10;
        this.f22171l = str11;
    }
}
