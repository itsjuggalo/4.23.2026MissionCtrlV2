package j6;

import j6.AbstractC2241e;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: j6.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2243g extends AbstractC2241e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f20170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f20171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f20172c;

    public C2243g(Map memberAnnotations, Map propertyConstants, Map annotationParametersDefaultValues) {
        AbstractC2304t.f(memberAnnotations, "memberAnnotations");
        AbstractC2304t.f(propertyConstants, "propertyConstants");
        AbstractC2304t.f(annotationParametersDefaultValues, "annotationParametersDefaultValues");
        this.f20170a = memberAnnotations;
        this.f20171b = propertyConstants;
        this.f20172c = annotationParametersDefaultValues;
    }

    @Override // j6.AbstractC2241e.a
    public Map a() {
        return this.f20170a;
    }

    public final Map b() {
        return this.f20172c;
    }

    public final Map c() {
        return this.f20171b;
    }
}
