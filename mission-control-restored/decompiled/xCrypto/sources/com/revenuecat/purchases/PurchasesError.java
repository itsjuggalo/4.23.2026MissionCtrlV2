package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesError implements Parcelable, Serializable {
    private static final long serialVersionUID = 81719171;
    private final PurchasesErrorCode code;
    private final String underlyingErrorMessage;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<PurchasesError> CREATOR = new Creator();

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    public static final class Creator implements Parcelable.Creator<PurchasesError> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PurchasesError createFromParcel(Parcel parcel) {
            r.f(parcel, "parcel");
            return new PurchasesError(PurchasesErrorCode.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PurchasesError[] newArray(int i4) {
            return new PurchasesError[i4];
        }
    }

    public PurchasesError(PurchasesErrorCode code, String str) {
        r.f(code, "code");
        this.code = code;
        this.underlyingErrorMessage = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!r.b(PurchasesError.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        r.d(obj, "null cannot be cast to non-null type com.revenuecat.purchases.PurchasesError");
        PurchasesError purchasesError = (PurchasesError) obj;
        return this.code == purchasesError.code && r.b(this.underlyingErrorMessage, purchasesError.underlyingErrorMessage);
    }

    public final PurchasesErrorCode getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.code.getDescription();
    }

    public final String getUnderlyingErrorMessage() {
        return this.underlyingErrorMessage;
    }

    public int hashCode() {
        int iHashCode = this.code.hashCode() * 31;
        String str = this.underlyingErrorMessage;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "PurchasesError(code=" + this.code + ", underlyingErrorMessage=" + this.underlyingErrorMessage + ", message='" + getMessage() + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i4) {
        r.f(out, "out");
        out.writeString(this.code.name());
        out.writeString(this.underlyingErrorMessage);
    }

    public /* synthetic */ PurchasesError(PurchasesErrorCode purchasesErrorCode, String str, int i4, AbstractC1585j abstractC1585j) {
        this(purchasesErrorCode, (i4 & 2) != 0 ? null : str);
    }
}
