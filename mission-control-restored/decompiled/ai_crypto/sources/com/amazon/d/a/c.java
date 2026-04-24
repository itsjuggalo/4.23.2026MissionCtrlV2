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
        private static final String f10169a = "com.amazon.venezia.command.Command";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f10170b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int f10171c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f10172d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final int f10173e = 4;

        /* JADX INFO: renamed from: com.amazon.d.a.c$a$a, reason: collision with other inner class name */
        public static class C0166a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10174a;

            public C0166a(IBinder iBinder) {
                this.f10174a = iBinder;
            }

            @Override // com.amazon.d.a.c
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f10169a);
                    this.f10174a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10174a;
            }

            @Override // com.amazon.d.a.c
            public String b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f10169a);
                    this.f10174a.transact(1, parcelObtain, parcelObtain2, 0);
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
                    parcelObtain.writeInterfaceToken(a.f10169a);
                    this.f10174a.transact(4, parcelObtain, parcelObtain2, 0);
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
                    parcelObtain.writeInterfaceToken(a.f10169a);
                    this.f10174a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String e() {
                return a.f10169a;
            }
        }

        public a() {
            attachInterface(this, f10169a);
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f10169a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0166a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) {
            if (i7 == 1) {
                parcel.enforceInterface(f10169a);
                String strB = b();
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            }
            if (i7 == 2) {
                parcel.enforceInterface(f10169a);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i7 == 3) {
                parcel.enforceInterface(f10169a);
                String strD = d();
                parcel2.writeNoException();
                parcel2.writeString(strD);
                return true;
            }
            if (i7 != 4) {
                if (i7 != 1598968902) {
                    return super.onTransact(i7, parcel, parcel2, i8);
                }
                parcel2.writeString(f10169a);
                return true;
            }
            parcel.enforceInterface(f10169a);
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
