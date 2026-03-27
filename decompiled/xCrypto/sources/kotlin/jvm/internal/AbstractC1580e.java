package kotlin.jvm.internal;

import h3.C1283b;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import p3.InterfaceC1715b;

/* JADX INFO: renamed from: kotlin.jvm.internal.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1580e implements InterfaceC1715b, Serializable {
    public static final Object NO_RECEIVER = a.f13419a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient InterfaceC1715b reflected;
    private final String signature;

    /* JADX INFO: renamed from: kotlin.jvm.internal.e$a */
    public static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13419a = new a();
    }

    public AbstractC1580e(Object obj, Class cls, String str, String str2, boolean z4) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z4;
    }

    @Override // p3.InterfaceC1715b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // p3.InterfaceC1715b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public InterfaceC1715b compute() {
        InterfaceC1715b interfaceC1715b = this.reflected;
        if (interfaceC1715b != null) {
            return interfaceC1715b;
        }
        InterfaceC1715b interfaceC1715bComputeReflected = computeReflected();
        this.reflected = interfaceC1715bComputeReflected;
        return interfaceC1715bComputeReflected;
    }

    public abstract InterfaceC1715b computeReflected();

    @Override // p3.InterfaceC1714a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // p3.InterfaceC1715b
    public String getName() {
        return this.name;
    }

    public p3.e getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? G.c(cls) : G.b(cls);
    }

    @Override // p3.InterfaceC1715b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public InterfaceC1715b getReflected() {
        InterfaceC1715b interfaceC1715bCompute = compute();
        if (interfaceC1715bCompute != this) {
            return interfaceC1715bCompute;
        }
        throw new C1283b();
    }

    @Override // p3.InterfaceC1715b
    public p3.k getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // p3.InterfaceC1715b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // p3.InterfaceC1715b
    public p3.l getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // p3.InterfaceC1715b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // p3.InterfaceC1715b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // p3.InterfaceC1715b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // p3.InterfaceC1715b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
