package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.amazon.d.a.a;
import com.amazon.d.a.e;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface f extends IInterface {
    String a();

    void a(e eVar);

    String b();

    String c();

    long d();

    com.amazon.d.a.a e();

    com.amazon.d.a.a f();

    com.amazon.d.a.a g();

    Map h();

    public static abstract class a extends Binder implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f10182a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f10183b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int f10184c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f10185d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final int f10186e = 5;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final int f10187f = 6;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final int f10188g = 7;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final int f10189h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final int f10190i = 9;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final String f10191j = "com.amazon.venezia.command.DecisionResult";

        public a() {
            attachInterface(this, f10191j);
        }

        public static f a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f10191j);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof f)) ? new C0169a(iBinder) : (f) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) {
            if (i7 == 1598968902) {
                parcel2.writeString(f10191j);
                return true;
            }
            switch (i7) {
                case 1:
                    parcel.enforceInterface(f10191j);
                    String strA = a();
                    parcel2.writeNoException();
                    parcel2.writeString(strA);
                    return true;
                case 2:
                    parcel.enforceInterface(f10191j);
                    String strB = b();
                    parcel2.writeNoException();
                    parcel2.writeString(strB);
                    return true;
                case 3:
                    parcel.enforceInterface(f10191j);
                    String strC = c();
                    parcel2.writeNoException();
                    parcel2.writeString(strC);
                    return true;
                case 4:
                    parcel.enforceInterface(f10191j);
                    long jD = d();
                    parcel2.writeNoException();
                    parcel2.writeLong(jD);
                    return true;
                case 5:
                    parcel.enforceInterface(f10191j);
                    a(e.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(f10191j);
                    com.amazon.d.a.a aVarE = e();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(aVarE != null ? aVarE.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface(f10191j);
                    com.amazon.d.a.a aVarF = f();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(aVarF != null ? aVarF.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface(f10191j);
                    com.amazon.d.a.a aVarG = g();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(aVarG != null ? aVarG.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface(f10191j);
                    Map mapH = h();
                    parcel2.writeNoException();
                    parcel2.writeMap(mapH);
                    return true;
                default:
                    return super.onTransact(i7, parcel, parcel2, i8);
            }
        }

        /* JADX INFO: renamed from: com.amazon.d.a.f$a$a, reason: collision with other inner class name */
        public static class C0169a implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10192a;

            public C0169a(IBinder iBinder) {
                this.f10192a = iBinder;
            }

            @Override // com.amazon.d.a.f
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f10191j);
                    this.f10192a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10192a;
            }

            @Override // com.amazon.d.a.f
            public String b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f10191j);
                    this.f10192a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.f
            public String c() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f10191j);
                    this.f10192a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.f
            public long d() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f10191j);
                    this.f10192a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.f
            public com.amazon.d.a.a e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f10191j);
                    this.f10192a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return a.AbstractBinderC0163a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.f
            public com.amazon.d.a.a f() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f10191j);
                    this.f10192a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return a.AbstractBinderC0163a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.f
            public com.amazon.d.a.a g() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f10191j);
                    this.f10192a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return a.AbstractBinderC0163a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.f
            public Map h() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f10191j);
                    this.f10192a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String i() {
                return a.f10191j;
            }

            @Override // com.amazon.d.a.f
            public void a(e eVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f10191j);
                    parcelObtain.writeStrongBinder(eVar != null ? eVar.asBinder() : null);
                    this.f10192a.transact(5, parcelObtain, parcelObtain2, 0);
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
