package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1346i implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f15424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15425b;

    public AbstractC1346i(IBinder iBinder, String str) {
        this.f15424a = iBinder;
        this.f15425b = str;
    }

    public final Parcel D() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f15425b);
        return parcelObtain;
    }

    public final Parcel E(int i8, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f15424a.transact(i8, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e8) {
                parcelObtain.recycle();
                throw e8;
            }
        } finally {
            parcel.recycle();
        }
    }

    public final void F(int i8, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f15424a.transact(i8, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    public final void G(int i8, Parcel parcel) {
        try {
            this.f15424a.transact(i8, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f15424a;
    }
}
