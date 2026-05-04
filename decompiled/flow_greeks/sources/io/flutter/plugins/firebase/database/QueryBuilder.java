package io.flutter.plugins.firebase.database;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\u001a\b\u0001\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\rJ#\u0010\u000f\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\rJ#\u0010\u0010\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\rJ#\u0010\u0011\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\rJ#\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\rJ#\u0010\u0013\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\rJ\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R&\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/flutter/plugins/firebase/database/QueryBuilder;", "", "Le8/e;", "ref", "", "", "", Constants.MODIFIERS, "<init>", "(Le8/e;Ljava/util/List;)V", "modifier", "Lcd/h0;", Constants.LIMIT, "(Ljava/util/Map;)V", Constants.ORDER_BY, "cursor", Constants.START_AT, Constants.START_AFTER, Constants.END_AT, Constants.END_BEFORE, "Le8/p;", "build", "()Le8/p;", "Ljava/util/List;", "query", "Le8/p;", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QueryBuilder {
    private final List<Map<String, Object>> modifiers;
    private e8.p query;

    /* JADX WARN: Multi-variable type inference failed */
    public QueryBuilder(e8.e ref, List<? extends Map<String, ? extends Object>> modifiers) {
        kotlin.jvm.internal.t.f(ref, "ref");
        kotlin.jvm.internal.t.f(modifiers, "modifiers");
        this.modifiers = modifiers;
        this.query = ref;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void cursor(Map<String, ? extends Object> modifier) {
        Object obj = modifier.get("name");
        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        switch (str.hashCode()) {
            case -1897186251:
                if (str.equals(Constants.START_AT)) {
                    startAt(modifier);
                }
                break;
            case -1601257830:
                if (str.equals(Constants.START_AFTER)) {
                    startAfter(modifier);
                    break;
                }
                break;
            case 96650862:
                if (str.equals(Constants.END_AT)) {
                    endAt(modifier);
                    break;
                }
                break;
            case 1108304954:
                if (str.equals(Constants.END_BEFORE)) {
                    endBefore(modifier);
                    break;
                }
                break;
        }
    }

    private final void endAt(Map<String, ? extends Object> modifier) {
        e8.p pVarG;
        Object obj = modifier.get("value");
        String str = (String) modifier.get("key");
        if (obj instanceof Boolean) {
            pVarG = str == null ? this.query.i(((Boolean) obj).booleanValue()) : this.query.j(((Boolean) obj).booleanValue(), str);
            kotlin.jvm.internal.t.e(pVarG, "endAt(...)");
        } else if (obj instanceof Number) {
            pVarG = str == null ? this.query.d(((Number) obj).doubleValue()) : this.query.e(((Number) obj).doubleValue(), str);
            kotlin.jvm.internal.t.e(pVarG, "endAt(...)");
        } else {
            if (str == null) {
                e8.p pVar = this.query;
                kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
                pVarG = pVar.f((String) obj);
            } else {
                e8.p pVar2 = this.query;
                kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
                pVarG = pVar2.g((String) obj, str);
            }
            kotlin.jvm.internal.t.e(pVarG, "endAt(...)");
        }
        this.query = pVarG;
    }

    private final void endBefore(Map<String, ? extends Object> modifier) {
        e8.p pVarN;
        Object obj = modifier.get("value");
        String str = (String) modifier.get("key");
        if (obj instanceof Boolean) {
            pVarN = str == null ? this.query.p(((Boolean) obj).booleanValue()) : this.query.q(((Boolean) obj).booleanValue(), str);
            kotlin.jvm.internal.t.e(pVarN, "endBefore(...)");
        } else if (obj instanceof Number) {
            pVarN = str == null ? this.query.k(((Number) obj).doubleValue()) : this.query.l(((Number) obj).doubleValue(), str);
            kotlin.jvm.internal.t.e(pVarN, "endBefore(...)");
        } else {
            if (str == null) {
                e8.p pVar = this.query;
                kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
                pVarN = pVar.m((String) obj);
            } else {
                e8.p pVar2 = this.query;
                kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
                pVarN = pVar2.n((String) obj, str);
            }
            kotlin.jvm.internal.t.e(pVarN, "endBefore(...)");
        }
        this.query = pVarN;
    }

    private final void limit(Map<String, ? extends Object> modifier) {
        e8.p pVarX;
        Object obj = modifier.get("name");
        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        Object obj2 = modifier.get(Constants.LIMIT);
        kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj2).intValue();
        if (kotlin.jvm.internal.t.b(str, Constants.LIMIT_TO_FIRST)) {
            pVarX = this.query.w(iIntValue);
            kotlin.jvm.internal.t.e(pVarX, "limitToFirst(...)");
        } else if (kotlin.jvm.internal.t.b(str, Constants.LIMIT_TO_LAST)) {
            pVarX = this.query.x(iIntValue);
            kotlin.jvm.internal.t.e(pVarX, "limitToLast(...)");
        } else {
            pVarX = this.query;
        }
        this.query = pVarX;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void orderBy(java.util.Map<java.lang.String, ? extends java.lang.Object> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "name"
            java.lang.Object r0 = r4.get(r0)
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            kotlin.jvm.internal.t.d(r0, r1)
            java.lang.String r0 = (java.lang.String) r0
            int r2 = r0.hashCode()
            switch(r2) {
                case -626148087: goto L5d;
                case 729747418: goto L48;
                case 1200288727: goto L2a;
                case 1217630252: goto L15;
                default: goto L14;
            }
        L14:
            goto L65
        L15:
            java.lang.String r4 = "orderByValue"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L1e
            goto L65
        L1e:
            e8.p r4 = r3.query
            e8.p r4 = r4.B()
            java.lang.String r0 = "orderByValue(...)"
            kotlin.jvm.internal.t.e(r4, r0)
            goto L73
        L2a:
            java.lang.String r2 = "orderByChild"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L33
            goto L65
        L33:
            java.lang.String r0 = "path"
            java.lang.Object r4 = r4.get(r0)
            kotlin.jvm.internal.t.d(r4, r1)
            java.lang.String r4 = (java.lang.String) r4
            e8.p r0 = r3.query
            e8.p r4 = r0.y(r4)
            kotlin.jvm.internal.t.c(r4)
            goto L73
        L48:
            java.lang.String r4 = "orderByKey"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L51
            goto L65
        L51:
            e8.p r4 = r3.query
            e8.p r4 = r4.z()
            java.lang.String r0 = "orderByKey(...)"
            kotlin.jvm.internal.t.e(r4, r0)
            goto L73
        L5d:
            java.lang.String r4 = "orderByPriority"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L68
        L65:
            e8.p r4 = r3.query
            goto L73
        L68:
            e8.p r4 = r3.query
            e8.p r4 = r4.A()
            java.lang.String r0 = "orderByPriority(...)"
            kotlin.jvm.internal.t.e(r4, r0)
        L73:
            r3.query = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.database.QueryBuilder.orderBy(java.util.Map):void");
    }

    private final void startAfter(Map<String, ? extends Object> modifier) {
        e8.p pVarI;
        Object obj = modifier.get("value");
        String str = (String) modifier.get("key");
        if (obj instanceof Boolean) {
            pVarI = str == null ? this.query.K(((Boolean) obj).booleanValue()) : this.query.L(((Boolean) obj).booleanValue(), str);
            kotlin.jvm.internal.t.e(pVarI, "startAfter(...)");
        } else if (obj instanceof Number) {
            pVarI = str == null ? this.query.F(((Number) obj).doubleValue()) : this.query.G(((Number) obj).doubleValue(), str);
            kotlin.jvm.internal.t.e(pVarI, "startAfter(...)");
        } else {
            if (str == null) {
                e8.p pVar = this.query;
                kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
                pVarI = pVar.H((String) obj);
            } else {
                e8.p pVar2 = this.query;
                kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
                pVarI = pVar2.I((String) obj, str);
            }
            kotlin.jvm.internal.t.e(pVarI, "startAfter(...)");
        }
        this.query = pVarI;
    }

    private final void startAt(Map<String, ? extends Object> modifier) {
        e8.p pVarP;
        Object obj = modifier.get("value");
        String str = (String) modifier.get("key");
        if (obj instanceof Boolean) {
            pVarP = str == null ? this.query.R(((Boolean) obj).booleanValue()) : this.query.S(((Boolean) obj).booleanValue(), str);
            kotlin.jvm.internal.t.e(pVarP, "startAt(...)");
        } else if (obj instanceof Number) {
            pVarP = str == null ? this.query.M(((Number) obj).doubleValue()) : this.query.N(((Number) obj).doubleValue(), str);
            kotlin.jvm.internal.t.e(pVarP, "startAt(...)");
        } else {
            if (str == null) {
                e8.p pVar = this.query;
                kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
                pVarP = pVar.O((String) obj);
            } else {
                e8.p pVar2 = this.query;
                kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
                pVarP = pVar2.P((String) obj, str);
            }
            kotlin.jvm.internal.t.e(pVarP, "startAt(...)");
        }
        this.query = pVarP;
    }

    public final e8.p build() {
        if (this.modifiers.isEmpty()) {
            return this.query;
        }
        Iterator<Map<String, Object>> it = this.modifiers.iterator();
        while (it.hasNext()) {
            Map<String, ? extends Object> map = (Map) it.next();
            Object obj = map.get("type");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            int iHashCode = str.hashCode();
            if (iHashCode != -1349119146) {
                if (iHashCode != -1207110587) {
                    if (iHashCode == 102976443 && str.equals(Constants.LIMIT)) {
                        limit(map);
                    }
                } else if (str.equals(Constants.ORDER_BY)) {
                    orderBy(map);
                }
            } else if (str.equals("cursor")) {
                cursor(map);
            }
        }
        return this.query;
    }
}
