package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f8984a = "com.amazon.venezia.command.Command";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f8985b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int f8986c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f8987d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final int f8988e = 4;

        /* JADX INFO: renamed from: com.amazon.d.a.c$a$a, reason: collision with other inner class name */
        public static class C0133a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f8989a;

            public C0133a(IBinder iBinder) {
                this.f8989a = iBinder;
            }

            @Override // com.amazon.d.a.c
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f8984a);
                    this.f8989a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8989a;
            }

            @Override // com.amazon.d.a.c
            public String b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f8984a);
                    this.f8989a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.c
            public Map c() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f8984a);
                    this.f8989a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.c
            public String d() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f8984a);
                    this.f8989a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String e() {
                return a.f8984a;
            }
        }

        public a() {
            attachInterface(this, f8984a);
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f8984a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0133a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 == 1) {
                parcel.enforceInterface(f8984a);
                String strB = b();
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            }
            if (i4 == 2) {
                parcel.enforceInterface(f8984a);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i4 == 3) {
                parcel.enforceInterface(f8984a);
                String strD = d();
                parcel2.writeNoException();
                parcel2.writeString(strD);
                return true;
            }
            if (i4 != 4) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString(f8984a);
                return true;
            }
            parcel.enforceInterface(f8984a);
            Map mapC = c();
            parcel2.writeNoException();
            parcel2.writeMap(mapC);
            return true;
        }
    }

    String a();

    String b();

    Map c();

    String d();
}
