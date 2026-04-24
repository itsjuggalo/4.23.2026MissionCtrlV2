package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface e extends IInterface {

    public static abstract class a extends Binder implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f14289a = "com.amazon.venezia.command.DecisionExpirationContext";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int f14290c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f14291d = 2;

        /* JADX INFO: renamed from: com.amazon.d.a.e$a$a, reason: collision with other inner class name */
        public static class C0239a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f14292a;

            public C0239a(IBinder iBinder) {
                this.f14292a = iBinder;
            }

            @Override // com.amazon.d.a.e
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f14289a);
                    this.f14292a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14292a;
            }

            @Override // com.amazon.d.a.e
            public Map b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f14289a);
                    this.f14292a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String c() {
                return a.f14289a;
            }
        }

        public a() {
            attachInterface(this, f14289a);
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f14289a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new C0239a(iBinder) : (e) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) {
            if (i8 == 1) {
                parcel.enforceInterface(f14289a);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i8 != 2) {
                if (i8 != 1598968902) {
                    return super.onTransact(i8, parcel, parcel2, i9);
                }
                parcel2.writeString(f14289a);
                return true;
            }
            parcel.enforceInterface(f14289a);
            Map mapB = b();
            parcel2.writeNoException();
            parcel2.writeMap(mapB);
            return true;
        }
    }

    String a();

    Map b();
}
