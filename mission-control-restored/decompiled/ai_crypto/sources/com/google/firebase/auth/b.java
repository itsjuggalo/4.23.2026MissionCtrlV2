package com.google.firebase.auth;

import Z2.O;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public static class a extends Q1.a {
        public static final Parcelable.Creator<a> CREATOR = new e();

        public static a A() {
            return new a();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            Q1.c.b(parcel, Q1.c.a(parcel));
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.auth.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0192b {
        private static final S1.a zza = new S1.a("PhoneAuthProvider", new String[0]);

        public abstract void onCodeAutoRetrievalTimeOut(String str);

        public abstract void onCodeSent(String str, a aVar);

        public abstract void onVerificationCompleted(O o7);

        public abstract void onVerificationFailed(Q2.m mVar);
    }

    public static O a(String str, String str2) {
        return O.E(str, str2);
    }

    public static void b(com.google.firebase.auth.a aVar) {
        AbstractC1207s.k(aVar);
        FirebaseAuth.l0(aVar);
    }
}
