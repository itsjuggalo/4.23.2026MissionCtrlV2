package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\tJ1\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/PresentedOfferingContext;", "Landroid/os/Parcelable;", "", "offeringIdentifier", "placementIdentifier", "Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;", "targetingContext", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;)V", "(Ljava/lang/String;)V", "copy$purchases_defaultsRelease", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;)Lcom/revenuecat/purchases/PresentedOfferingContext;", "copy", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lo5/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getOfferingIdentifier", "()Ljava/lang/String;", "getPlacementIdentifier", "Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;", "getTargetingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;", "TargetingContext", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class PresentedOfferingContext implements Parcelable {
    public static final Parcelable.Creator<PresentedOfferingContext> CREATOR = new Creator();
    private final String offeringIdentifier;
    private final String placementIdentifier;
    private final TargetingContext targetingContext;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PresentedOfferingContext> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PresentedOfferingContext createFromParcel(Parcel parcel) {
            AbstractC2304t.f(parcel, "parcel");
            return new PresentedOfferingContext(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : TargetingContext.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PresentedOfferingContext[] newArray(int i8) {
            return new PresentedOfferingContext[i8];
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;", "Landroid/os/Parcelable;", "", "revision", "", "ruleId", "<init>", "(ILjava/lang/String;)V", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lo5/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getRevision", "Ljava/lang/String;", "getRuleId", "()Ljava/lang/String;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
    public static final class TargetingContext implements Parcelable {
        public static final Parcelable.Creator<TargetingContext> CREATOR = new Creator();
        private final int revision;
        private final String ruleId;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<TargetingContext> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TargetingContext createFromParcel(Parcel parcel) {
                AbstractC2304t.f(parcel, "parcel");
                return new TargetingContext(parcel.readInt(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TargetingContext[] newArray(int i8) {
                return new TargetingContext[i8];
            }
        }

        public TargetingContext(int i8, String ruleId) {
            AbstractC2304t.f(ruleId, "ruleId");
            this.revision = i8;
            this.ruleId = ruleId;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TargetingContext)) {
                return false;
            }
            TargetingContext targetingContext = (TargetingContext) obj;
            return this.revision == targetingContext.revision && AbstractC2304t.b(this.ruleId, targetingContext.ruleId);
        }

        public final int getRevision() {
            return this.revision;
        }

        public final String getRuleId() {
            return this.ruleId;
        }

        public int hashCode() {
            return (this.revision * 31) + this.ruleId.hashCode();
        }

        public String toString() {
            return "TargetingContext(revision=" + this.revision + ", ruleId=" + this.ruleId + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            AbstractC2304t.f(parcel, "out");
            parcel.writeInt(this.revision);
            parcel.writeString(this.ruleId);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PresentedOfferingContext(String offeringIdentifier) {
        this(offeringIdentifier, null, null);
        AbstractC2304t.f(offeringIdentifier, "offeringIdentifier");
    }

    public static /* synthetic */ PresentedOfferingContext copy$purchases_defaultsRelease$default(PresentedOfferingContext presentedOfferingContext, String str, String str2, TargetingContext targetingContext, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = presentedOfferingContext.offeringIdentifier;
        }
        if ((i8 & 2) != 0) {
            str2 = presentedOfferingContext.placementIdentifier;
        }
        if ((i8 & 4) != 0) {
            targetingContext = presentedOfferingContext.targetingContext;
        }
        return presentedOfferingContext.copy$purchases_defaultsRelease(str, str2, targetingContext);
    }

    public final /* synthetic */ PresentedOfferingContext copy$purchases_defaultsRelease(String offeringIdentifier, String placementIdentifier, TargetingContext targetingContext) {
        AbstractC2304t.f(offeringIdentifier, "offeringIdentifier");
        return new PresentedOfferingContext(offeringIdentifier, placementIdentifier, targetingContext);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PresentedOfferingContext)) {
            return false;
        }
        PresentedOfferingContext presentedOfferingContext = (PresentedOfferingContext) obj;
        return AbstractC2304t.b(this.offeringIdentifier, presentedOfferingContext.offeringIdentifier) && AbstractC2304t.b(this.placementIdentifier, presentedOfferingContext.placementIdentifier) && AbstractC2304t.b(this.targetingContext, presentedOfferingContext.targetingContext);
    }

    public final String getOfferingIdentifier() {
        return this.offeringIdentifier;
    }

    public final String getPlacementIdentifier() {
        return this.placementIdentifier;
    }

    public final TargetingContext getTargetingContext() {
        return this.targetingContext;
    }

    public int hashCode() {
        int iHashCode = this.offeringIdentifier.hashCode() * 31;
        String str = this.placementIdentifier;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        TargetingContext targetingContext = this.targetingContext;
        return iHashCode2 + (targetingContext != null ? targetingContext.hashCode() : 0);
    }

    public String toString() {
        return "PresentedOfferingContext(offeringIdentifier=" + this.offeringIdentifier + ", placementIdentifier=" + this.placementIdentifier + ", targetingContext=" + this.targetingContext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        AbstractC2304t.f(parcel, "out");
        parcel.writeString(this.offeringIdentifier);
        parcel.writeString(this.placementIdentifier);
        TargetingContext targetingContext = this.targetingContext;
        if (targetingContext == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            targetingContext.writeToParcel(parcel, flags);
        }
    }

    public PresentedOfferingContext(String offeringIdentifier, String str, TargetingContext targetingContext) {
        AbstractC2304t.f(offeringIdentifier, "offeringIdentifier");
        this.offeringIdentifier = offeringIdentifier;
        this.placementIdentifier = str;
        this.targetingContext = targetingContext;
    }
}
