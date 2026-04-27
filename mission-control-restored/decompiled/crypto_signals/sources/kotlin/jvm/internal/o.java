package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes.dex */
public abstract class o extends c implements W4.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7930a;

    public o(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.f7930a = false;
    }

    @Override // kotlin.jvm.internal.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final W4.h getReflected() {
        if (this.f7930a) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        W4.b bVarCompute = compute();
        if (bVarCompute != this) {
            return (W4.h) bVarCompute;
        }
        throw new Q4.a("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    @Override // kotlin.jvm.internal.c
    public final W4.b compute() {
        return this.f7930a ? this : super.compute();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            return getOwner().equals(oVar.getOwner()) && getName().equals(oVar.getName()) && getSignature().equals(oVar.getSignature()) && j.a(getBoundReceiver(), oVar.getBoundReceiver());
        }
        if (obj instanceof W4.h) {
            return obj.equals(compute());
        }
        return false;
    }

    public final int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    public final String toString() {
        W4.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
