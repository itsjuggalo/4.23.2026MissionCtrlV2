package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface g extends IInterface {

    public static abstract class a extends Binder implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f10193a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f10194b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f10195c = "com.amazon.venezia.command.ExceptionResult";

        /* JADX INFO: renamed from: com.amazon.d.a.g$a$a, reason: collision with other inner class name */
        public static class C0170a implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10196a;

            public C0170a(IBinder iBinder) {
                this.f10196a = iBinder;
            }

            @Override // com.amazon.d.a.g
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f10195c);
                    this.f10196a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10196a;
            }

            @Override // com.amazon.d.a.g
            public Map b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f10195c);
                    this.f10196a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String c() {
                return a.f10195c;
            }
        }

        public a() {
            attachInterface(this, f10195c);
        }

        public static g a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f10195c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof g)) ? new C0170a(iBinder) : (g) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) {
            if (i7 == 1) {
                parcel.enforceInterface(f10195c);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i7 != 2) {
                if (i7 != 1598968902) {
                    return super.onTransact(i7, parcel, parcel2, i8);
                }
                parcel2.writeString(f10195c);
                return true;
            }
            parcel.enforceInterface(f10195c);
            Map mapB = b();
            parcel2.writeNoException();
            parcel2.writeMap(mapB);
            return true;
        }
    }

    String a();

    Map b();
}
