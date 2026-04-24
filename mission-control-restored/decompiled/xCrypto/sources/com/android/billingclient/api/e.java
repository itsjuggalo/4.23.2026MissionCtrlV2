package com.android.billingclient.api;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9439b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f9440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9441b;

        public a() {
        }

        public e a() {
            if (!this.f9440a) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            return new e(true, this.f9441b);
        }

        public a b() {
            this.f9440a = true;
            return this;
        }

        public a c() {
            this.f9441b = true;
            return this;
        }
    }

    public e(boolean z4, boolean z5) {
        this.f9438a = z4;
        this.f9439b = z5;
    }

    public static a c() {
        return new a();
    }

    public boolean a() {
        return this.f9438a;
    }

    public boolean b() {
        return this.f9439b;
    }
}
