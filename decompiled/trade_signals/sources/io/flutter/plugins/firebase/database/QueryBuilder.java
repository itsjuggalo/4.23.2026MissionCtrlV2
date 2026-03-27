package io.flutter.plugins.firebase.database;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class QueryBuilder {
    private final List<Map<String, Object>> modifiers;
    private c3.p query;

    public QueryBuilder(c3.e eVar, List<Map<String, Object>> list) {
        this.query = eVar;
        this.modifiers = list;
    }

    private void cursor(Map<String, Object> map) {
        Object obj = map.get("name");
        Objects.requireNonNull(obj);
        switch ((String) obj) {
            case "startAt":
                startAt(map);
                break;
            case "startAfter":
                startAfter(map);
                break;
            case "endAt":
                endAt(map);
                break;
            case "endBefore":
                endBefore(map);
                break;
        }
    }

    private void endAt(Map<String, Object> map) {
        Object obj = map.get("value");
        String str = (String) map.get("key");
        this.query = obj instanceof Boolean ? str == null ? this.query.i(((Boolean) obj).booleanValue()) : this.query.j(((Boolean) obj).booleanValue(), str) : obj instanceof Number ? str == null ? this.query.d(((Number) obj).doubleValue()) : this.query.e(((Number) obj).doubleValue(), str) : str == null ? this.query.f((String) obj) : this.query.g((String) obj, str);
    }

    private void endBefore(Map<String, Object> map) {
        Object obj = map.get("value");
        String str = (String) map.get("key");
        this.query = obj instanceof Boolean ? str == null ? this.query.p(((Boolean) obj).booleanValue()) : this.query.q(((Boolean) obj).booleanValue(), str) : obj instanceof Number ? str == null ? this.query.k(((Number) obj).doubleValue()) : this.query.l(((Number) obj).doubleValue(), str) : str == null ? this.query.m((String) obj) : this.query.n((String) obj, str);
    }

    private void limit(Map<String, Object> map) {
        c3.p pVarX;
        Object obj = map.get("name");
        Objects.requireNonNull(obj);
        String str = (String) obj;
        Object obj2 = map.get(Constants.LIMIT);
        Objects.requireNonNull(obj2);
        int iIntValue = ((Integer) obj2).intValue();
        if (Constants.LIMIT_TO_FIRST.equals(str)) {
            pVarX = this.query.w(iIntValue);
        } else if (!Constants.LIMIT_TO_LAST.equals(str)) {
            return;
        } else {
            pVarX = this.query.x(iIntValue);
        }
        this.query = pVarX;
    }

    private void orderBy(Map<String, Object> map) {
        c3.p pVarA;
        Object obj = map.get("name");
        Objects.requireNonNull(obj);
        switch ((String) obj) {
            case "orderByPriority":
                pVarA = this.query.A();
                break;
            case "orderByKey":
                pVarA = this.query.z();
                break;
            case "orderByChild":
                Object obj2 = map.get(Constants.PATH);
                Objects.requireNonNull(obj2);
                pVarA = this.query.y((String) obj2);
                break;
            case "orderByValue":
                pVarA = this.query.B();
                break;
            default:
                return;
        }
        this.query = pVarA;
    }

    private void startAfter(Map<String, Object> map) {
        Object obj = map.get("value");
        String str = (String) map.get("key");
        this.query = obj instanceof Boolean ? str == null ? this.query.K(((Boolean) obj).booleanValue()) : this.query.L(((Boolean) obj).booleanValue(), str) : obj instanceof Number ? str == null ? this.query.F(((Number) obj).doubleValue()) : this.query.G(((Number) obj).doubleValue(), str) : str == null ? this.query.H((String) obj) : this.query.I((String) obj, str);
    }

    private void startAt(Map<String, Object> map) {
        Object obj = map.get("value");
        String str = (String) map.get("key");
        this.query = obj instanceof Boolean ? str == null ? this.query.R(((Boolean) obj).booleanValue()) : this.query.S(((Boolean) obj).booleanValue(), str) : obj instanceof Number ? str == null ? this.query.M(((Number) obj).doubleValue()) : this.query.N(((Number) obj).doubleValue(), str) : str == null ? this.query.O((String) obj) : this.query.P((String) obj, str);
    }

    public c3.p build() {
        if (this.modifiers.isEmpty()) {
            return this.query;
        }
        for (Map<String, Object> map : this.modifiers) {
            Object obj = map.get("type");
            Objects.requireNonNull(obj);
            switch ((String) obj) {
                case "cursor":
                    cursor(map);
                    break;
                case "orderBy":
                    orderBy(map);
                    break;
                case "limit":
                    limit(map);
                    break;
            }
        }
        return this.query;
    }
}
