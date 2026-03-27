package com.amazon.d.c.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {
    String a();

    String a(String str);

    void a(String str, boolean z4, String str2);

    String b();

    /* JADX INFO: renamed from: com.amazon.d.c.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0141a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f9038a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f9039b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int f9040c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f9041d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f9042e = "com.amazon.venezia.service.verify.IApplicationVerificationService";

        public AbstractBinderC0141a() {
            attachInterface(this, f9042e);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f9042e);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0142a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 == 1) {
                parcel.enforceInterface(f9042e);
                a(parcel.readString(), parcel.readInt() != 0, parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i4 == 2) {
                parcel.enforceInterface(f9042e);
                String strA = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i4 == 3) {
                parcel.enforceInterface(f9042e);
                String strA2 = a();
                parcel2.writeNoException();
                parcel2.writeString(strA2);
                return true;
            }
            if (i4 != 4) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString(f9042e);
                return true;
            }
            parcel.enforceInterface(f9042e);
            String strB = b();
            parcel2.writeNoException();
            parcel2.writeString(strB);
            return true;
        }

        /* JADX INFO: renamed from: com.amazon.d.c.a.a$a$a, reason: collision with other inner class name */
        public static class C0142a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f9043a;

            public C0142a(IBinder iBinder) {
                this.f9043a = iBinder;
            }

            @Override // com.amazon.d.c.a.a
            public void a(String str, boolean z4, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0141a.f9042e);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z4 ? 1 : 0);
                    parcelObtain.writeString(str2);
                    this.f9043a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9043a;
            }

            @Override // com.amazon.d.c.a.a
            public String b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0141a.f9042e);
                    this.f9043a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String c() {
                return AbstractBinderC0141a.f9042e;
            }

            @Override // com.amazon.d.c.a.a
            public String a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0141a.f9042e);
                    parcelObtain.writeString(str);
                    this.f9043a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.c.a.a
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0141a.f9042e);
                    this.f9043a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
