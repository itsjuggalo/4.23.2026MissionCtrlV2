package com.android.billingclient.api;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10624b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f10625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f10626b;

        public a() {
        }

        public e a() {
            if (!this.f10625a) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            return new e(true, this.f10626b);
        }

        public a b() {
            this.f10625a = true;
            return this;
        }

        public a c() {
            this.f10626b = true;
            return this;
        }
    }

    public e(boolean z7, boolean z8) {
        this.f10623a = z7;
        this.f10624b = z8;
    }

    public static a c() {
        return new a();
    }

    public boolean a() {
        return this.f10623a;
    }

    public boolean b() {
        return this.f10624b;
    }
}
