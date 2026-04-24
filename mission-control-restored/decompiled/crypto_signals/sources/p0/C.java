package p0;

/* JADX INFO: loaded from: classes.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8963d;
    public boolean e;

    public final int a() {
        if (this.f8962c) {
            return 0 - this.f8960a;
        }
        return 0;
    }

    public final String toString() {
        return "State{mTargetPosition=-1, mData=null, mItemCount=0, mIsMeasuring=false, mPreviousLayoutItemCount=0, mDeletedInvisibleItemCountSincePreviousLayout=" + this.f8960a + ", mStructureChanged=" + this.f8961b + ", mInPreLayout=" + this.f8962c + ", mRunSimpleAnimations=" + this.f8963d + ", mRunPredictiveAnimations=" + this.e + '}';
    }
}
