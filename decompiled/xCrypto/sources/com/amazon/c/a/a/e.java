package com.amazon.c.a.a;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8969a = String.format("A valid instance of %s is required to have at least one non-blank ID, either developerId or certificateId, and at least one non-blank name, either developerName or commonName.", e.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8970b = String.format("A valid instance of %s is required to have a certificate ID.", e.class.getSimpleName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8974f;

    public static String a() {
        return f8969a;
    }

    public static String b() {
        return f8970b;
    }

    public boolean c() {
        return (StringUtils.isBlank(e()) || StringUtils.isBlank(f())) ? false : true;
    }

    public boolean d() {
        return !StringUtils.isBlank(e());
    }

    public String e() {
        return StringUtils.isBlank(this.f8973e) ? this.f8971c : this.f8973e;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return new EqualsBuilder().append(this.f8973e, eVar.f8973e).append(this.f8974f, eVar.f8974f).append(this.f8971c, eVar.f8971c).append(this.f8972d, eVar.f8972d).isEquals();
    }

    public String f() {
        return StringUtils.isBlank(this.f8974f) ? this.f8972d : this.f8974f;
    }

    public String g() {
        return this.f8971c;
    }

    public String h() {
        return this.f8972d;
    }

    public int hashCode() {
        return new HashCodeBuilder().append(this.f8973e).append(this.f8974f).append(this.f8971c).append(this.f8972d).toHashCode();
    }

    public String i() {
        return this.f8973e;
    }

    public String j() {
        return this.f8974f;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public e a(String str) {
        this.f8971c = str;
        return this;
    }

    public void b(String str) {
        this.f8971c = str;
    }

    public e c(String str) {
        this.f8972d = str;
        return this;
    }

    public void d(String str) {
        this.f8972d = str;
    }

    public e g(String str) {
        this.f8974f = str;
        return this;
    }

    public void h(String str) {
        this.f8974f = str;
    }

    public e e(String str) {
        this.f8973e = str;
        return this;
    }

    public void f(String str) {
        this.f8973e = str;
    }
}
