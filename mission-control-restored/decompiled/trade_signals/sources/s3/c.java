package s3;

import g0.AbstractC1776f;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static final Object a(AbstractC1776f abstractC1776f, AbstractC1776f.a key, Object obj) {
        AbstractC2304t.f(abstractC1776f, "<this>");
        AbstractC2304t.f(key, "key");
        Object objB = abstractC1776f.b(key);
        return objB == null ? obj : objB;
    }
}
