package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f implements wd.c, Serializable {
    public static final Object NO_RECEIVER = a.f14936a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient wd.c reflected;
    private final String signature;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14936a = new a();
    }

    public f(Object obj, Class cls, String str, String str2, boolean z10) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z10;
    }

    @Override // wd.c
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // wd.c
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public wd.c compute() {
        wd.c cVar = this.reflected;
        if (cVar != null) {
            return cVar;
        }
        wd.c cVarComputeReflected = computeReflected();
        this.reflected = cVarComputeReflected;
        return cVarComputeReflected;
    }

    public abstract wd.c computeReflected();

    @Override // wd.b
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // wd.c
    public String getName() {
        return this.name;
    }

    public wd.g getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? n0.c(cls) : n0.b(cls);
    }

    @Override // wd.c
    public List<wd.l> getParameters() {
        return getReflected().getParameters();
    }

    public wd.c getReflected() {
        wd.c cVarCompute = compute();
        if (cVarCompute != this) {
            return cVarCompute;
        }
        throw new od.b();
    }

    @Override // wd.c
    public wd.q getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // wd.c
    public List<wd.r> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // wd.c
    public wd.u getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // wd.c
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // wd.c
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // wd.c
    public boolean isOpen() {
        return getReflected().isOpen();
    }
}
