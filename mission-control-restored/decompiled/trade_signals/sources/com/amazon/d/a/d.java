package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.amazon.d.a.c;
import com.amazon.d.a.i;

/* JADX INFO: loaded from: classes.dex */
public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f14286a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f14287b = "com.amazon.venezia.command.CommandService";

        /* JADX INFO: renamed from: com.amazon.d.a.d$a$a, reason: collision with other inner class name */
        public static class C0238a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f14288a;

            public C0238a(IBinder iBinder) {
                this.f14288a = iBinder;
            }

            public String a() {
                return a.f14287b;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14288a;
            }

            @Override // com.amazon.d.a.d
            public void a(c cVar, i iVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f14287b);
                    parcelObtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    parcelObtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    this.f14288a.transact(1, parcelObtain, parcelObtain2, 0);
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

        public a() {
            attachInterface(this, f14287b);
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f14287b);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) ? new C0238a(iBinder) : (d) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) {
            if (i8 != 1) {
                if (i8 != 1598968902) {
                    return super.onTransact(i8, parcel, parcel2, i9);
                }
                parcel2.writeString(f14287b);
                return true;
            }
            parcel.enforceInterface(f14287b);
            a(c.a.a(parcel.readStrongBinder()), i.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    void a(c cVar, i iVar);
}
