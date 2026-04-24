package com.google.android.play.core.integrity;

/* JADX INFO: loaded from: classes.dex */
final class a extends ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private y f10069b;

    @Override // com.google.android.play.core.integrity.ap
    public final ap a(y yVar) {
        this.f10069b = yVar;
        return this;
    }

    @Override // com.google.android.play.core.integrity.ap
    public final ap b(String str) {
        this.f10068a = str;
        return this;
    }

    @Override // com.google.android.play.core.integrity.ap
    public final aq c() {
        y yVar;
        String str = this.f10068a;
        if (str != null && (yVar = this.f10069b) != null) {
            return new aq(str, yVar);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f10068a == null) {
            sb.append(" token");
        }
        if (this.f10069b == null) {
            sb.append(" integrityDialogWrapper");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
