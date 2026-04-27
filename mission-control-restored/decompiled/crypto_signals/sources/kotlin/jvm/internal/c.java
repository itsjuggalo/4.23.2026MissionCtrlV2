package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements W4.b, Serializable {
    public static final Object NO_RECEIVER = b.f7923a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient W4.b reflected;
    private final String signature;

    public c(Object obj, Class cls, String str, String str2, boolean z6) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z6;
    }

    @Override // W4.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // W4.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public W4.b compute() {
        W4.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        W4.b bVarComputeReflected = computeReflected();
        this.reflected = bVarComputeReflected;
        return bVarComputeReflected;
    }

    public abstract W4.b computeReflected();

    @Override // W4.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // W4.b
    public String getName() {
        return this.name;
    }

    public W4.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (!this.isTopLevel) {
            return t.a(cls);
        }
        t.f7935a.getClass();
        return new l(cls);
    }

    @Override // W4.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public abstract W4.b getReflected();

    @Override // W4.b
    public W4.i getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // W4.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // W4.b
    public W4.j getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // W4.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // W4.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // W4.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }
}
