package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: kotlin.jvm.internal.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2291f implements I5.c, Serializable {
    public static final Object NO_RECEIVER = a.f20488a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient I5.c reflected;
    private final String signature;

    /* JADX INFO: renamed from: kotlin.jvm.internal.f$a */
    public static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20488a = new a();
    }

    public AbstractC2291f(Object obj, Class cls, String str, String str2, boolean z7) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z7;
    }

    @Override // I5.c
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // I5.c
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public I5.c compute() {
        I5.c cVar = this.reflected;
        if (cVar != null) {
            return cVar;
        }
        I5.c cVarComputeReflected = computeReflected();
        this.reflected = cVarComputeReflected;
        return cVarComputeReflected;
    }

    public abstract I5.c computeReflected();

    @Override // I5.b
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // I5.c
    public String getName() {
        return this.name;
    }

    public I5.g getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? O.c(cls) : O.b(cls);
    }

    @Override // I5.c
    public List<I5.l> getParameters() {
        return getReflected().getParameters();
    }

    public I5.c getReflected() {
        I5.c cVarCompute = compute();
        if (cVarCompute != this) {
            return cVarCompute;
        }
        throw new A5.b();
    }

    @Override // I5.c
    public I5.q getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // I5.c
    public List<I5.r> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // I5.c
    public I5.u getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // I5.c
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // I5.c
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // I5.c
    public boolean isOpen() {
        return getReflected().isOpen();
    }
}
