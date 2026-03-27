package com.amazon.d.a;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.amazon.d.a.b;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {
    String a();

    void a(b bVar);

    Intent b();

    Map c();

    /* JADX INFO: renamed from: com.amazon.d.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0163a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f10160a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f10161b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int f10162c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f10163d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f10164e = "com.amazon.venezia.command.Choice";

        public AbstractBinderC0163a() {
            attachInterface(this, f10164e);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f10164e);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0164a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) {
            if (i7 == 1) {
                parcel.enforceInterface(f10164e);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i7 == 2) {
                parcel.enforceInterface(f10164e);
                Intent intentB = b();
                parcel2.writeNoException();
                if (intentB != null) {
                    parcel2.writeInt(1);
                    intentB.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i7 == 3) {
                parcel.enforceInterface(f10164e);
                a(b.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i7 != 4) {
                if (i7 != 1598968902) {
                    return super.onTransact(i7, parcel, parcel2, i8);
                }
                parcel2.writeString(f10164e);
                return true;
            }
            parcel.enforceInterface(f10164e);
            Map mapC = c();
            parcel2.writeNoException();
            parcel2.writeMap(mapC);
            return true;
        }

        /* JADX INFO: renamed from: com.amazon.d.a.a$a$a, reason: collision with other inner class name */
        public static class C0164a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10165a;

            public C0164a(IBinder iBinder) {
                this.f10165a = iBinder;
            }

            @Override // com.amazon.d.a.a
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0163a.f10164e);
                    this.f10165a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10165a;
            }

            @Override // com.amazon.d.a.a
            public Intent b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0163a.f10164e);
                    this.f10165a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.a
            public Map c() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0163a.f10164e);
                    this.f10165a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String d() {
                return AbstractBinderC0163a.f10164e;
            }

            @Override // com.amazon.d.a.a
            public void a(b bVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0163a.f10164e);
                    parcelObtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f10165a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }
    }
}
