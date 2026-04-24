package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class PresentedOfferingContext implements Parcelable {
    public static final Parcelable.Creator<PresentedOfferingContext> CREATOR = new Creator();
    private final String offeringIdentifier;
    private final String placementIdentifier;
    private final TargetingContext targetingContext;

    public static final class Creator implements Parcelable.Creator<PresentedOfferingContext> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PresentedOfferingContext createFromParcel(Parcel parcel) {
            r.f(parcel, "parcel");
            return new PresentedOfferingContext(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : TargetingContext.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PresentedOfferingContext[] newArray(int i7) {
            return new PresentedOfferingContext[i7];
        }
    }

    public static final class TargetingContext implements Parcelable {
        public static final Parcelable.Creator<TargetingContext> CREATOR = new Creator();
        private final int revision;
        private final String ruleId;

        public static final class Creator implements Parcelable.Creator<TargetingContext> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TargetingContext createFromParcel(Parcel parcel) {
                r.f(parcel, "parcel");
                return new TargetingContext(parcel.readInt(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TargetingContext[] newArray(int i7) {
                return new TargetingContext[i7];
            }
        }

        public TargetingContext(int i7, String ruleId) {
            r.f(ruleId, "ruleId");
            this.revision = i7;
            this.ruleId = ruleId;
        }

        public static /* synthetic */ TargetingContext copy$default(TargetingContext targetingContext, int i7, String str, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i7 = targetingContext.revision;
            }
            if ((i8 & 2) != 0) {
                str = targetingContext.ruleId;
            }
            return targetingContext.copy(i7, str);
        }

        public final int component1() {
            return this.revision;
        }

        public final String component2() {
            return this.ruleId;
        }

        public final TargetingContext copy(int i7, String ruleId) {
            r.f(ruleId, "ruleId");
            return new TargetingContext(i7, ruleId);
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
            return this.revision == targetingContext.revision && r.b(this.ruleId, targetingContext.ruleId);
        }

        public final int getRevision() {
            return this.revision;
        }

        public final String getRuleId() {
            return this.ruleId;
        }

        public int hashCode() {
            return (Integer.hashCode(this.revision) * 31) + this.ruleId.hashCode();
        }

        public String toString() {
            return "TargetingContext(revision=" + this.revision + ", ruleId=" + this.ruleId + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i7) {
            r.f(out, "out");
            out.writeInt(this.revision);
            out.writeString(this.ruleId);
        }
    }

    public PresentedOfferingContext(String offeringIdentifier, String str, TargetingContext targetingContext) {
        r.f(offeringIdentifier, "offeringIdentifier");
        this.offeringIdentifier = offeringIdentifier;
        this.placementIdentifier = str;
        this.targetingContext = targetingContext;
    }

    public static /* synthetic */ PresentedOfferingContext copy$default(PresentedOfferingContext presentedOfferingContext, String str, String str2, TargetingContext targetingContext, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = presentedOfferingContext.offeringIdentifier;
        }
        if ((i7 & 2) != 0) {
            str2 = presentedOfferingContext.placementIdentifier;
        }
        if ((i7 & 4) != 0) {
            targetingContext = presentedOfferingContext.targetingContext;
        }
        return presentedOfferingContext.copy(str, str2, targetingContext);
    }

    public final String component1() {
        return this.offeringIdentifier;
    }

    public final String component2() {
        return this.placementIdentifier;
    }

    public final TargetingContext component3() {
        return this.targetingContext;
    }

    public final PresentedOfferingContext copy(String offeringIdentifier, String str, TargetingContext targetingContext) {
        r.f(offeringIdentifier, "offeringIdentifier");
        return new PresentedOfferingContext(offeringIdentifier, str, targetingContext);
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
        return r.b(this.offeringIdentifier, presentedOfferingContext.offeringIdentifier) && r.b(this.placementIdentifier, presentedOfferingContext.placementIdentifier) && r.b(this.targetingContext, presentedOfferingContext.targetingContext);
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
    public void writeToParcel(Parcel out, int i7) {
        r.f(out, "out");
        out.writeString(this.offeringIdentifier);
        out.writeString(this.placementIdentifier);
        TargetingContext targetingContext = this.targetingContext;
        if (targetingContext == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            targetingContext.writeToParcel(out, i7);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PresentedOfferingContext(String offeringIdentifier) {
        this(offeringIdentifier, null, null);
        r.f(offeringIdentifier, "offeringIdentifier");
    }
}
