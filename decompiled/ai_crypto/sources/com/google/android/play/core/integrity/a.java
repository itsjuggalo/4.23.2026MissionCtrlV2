package com.google.android.play.core.integrity;

/* JADX INFO: loaded from: classes.dex */
final class a extends ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private y f11852b;

    @Override // com.google.android.play.core.integrity.ap
    public final ap a(y yVar) {
        this.f11852b = yVar;
        return this;
    }

    @Override // com.google.android.play.core.integrity.ap
    public final ap b(String str) {
        this.f11851a = str;
        return this;
    }

    @Override // com.google.android.play.core.integrity.ap
    public final aq c() {
        y yVar;
        String str = this.f11851a;
        if (str != null && (yVar = this.f11852b) != null) {
            return new aq(str, yVar);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f11851a == null) {
            sb.append(" token");
        }
        if (this.f11852b == null) {
            sb.append(" integrityDialogWrapper");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
