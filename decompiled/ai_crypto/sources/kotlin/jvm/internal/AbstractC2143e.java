package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: kotlin.jvm.internal.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2143e implements X5.b, Serializable {
    public static final Object NO_RECEIVER = a.f18258a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient X5.b reflected;
    private final String signature;

    /* JADX INFO: renamed from: kotlin.jvm.internal.e$a */
    public static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18258a = new a();
    }

    public AbstractC2143e(Object obj, Class cls, String str, String str2, boolean z7) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z7;
    }

    @Override // X5.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // X5.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public X5.b compute() {
        X5.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        X5.b bVarComputeReflected = computeReflected();
        this.reflected = bVarComputeReflected;
        return bVarComputeReflected;
    }

    public abstract X5.b computeReflected();

    @Override // X5.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // X5.b
    public String getName() {
        return this.name;
    }

    public X5.e getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? H.c(cls) : H.b(cls);
    }

    @Override // X5.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public X5.b getReflected() {
        X5.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute;
        }
        throw new P5.b();
    }

    @Override // X5.b
    public X5.k getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // X5.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // X5.b
    public X5.l getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // X5.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // X5.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // X5.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }
}
