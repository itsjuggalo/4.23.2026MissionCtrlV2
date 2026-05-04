.class public Lg9/e1;
.super Lg9/x0;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# direct methods
.method public constructor <init>(Lcom/google/firebase/firestore/g;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lg9/x0;-><init>(Lcom/google/firebase/firestore/g;)V

    .line 2
    .line 3
    .line 4
    return-void
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method


# virtual methods
.method public b(Lg9/j$a;)Li9/l4;
    .locals 2

    .line 1
    invoke-virtual {p0}, Lg9/j;->o()Li9/h1;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    check-cast v0, Li9/e3;

    .line 6
    .line 7
    invoke-virtual {v0}, Li9/e3;->A()Li9/m2;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    invoke-interface {v0}, Li9/m0;->f()Li9/q0;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    iget-object p1, p1, Lg9/j$a;->b:Ln9/g;

    .line 16
    .line 17
    invoke-virtual {p0}, Lg9/j;->n()Li9/k0;

    .line 18
    .line 19
    .line 20
    move-result-object v1

    .line 21
    invoke-virtual {v0, p1, v1}, Li9/q0;->i(Ln9/g;Li9/k0;)Li9/q0$a;

    .line 22
    .line 23
    .line 24
    move-result-object p1

    .line 25
    return-object p1
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
.end method

.method public c(Lg9/j$a;)Li9/l;
    .locals 3

    .line 1
    new-instance v0, Li9/l;

    .line 2
    .line 3
    invoke-virtual {p0}, Lg9/j;->o()Li9/h1;

    .line 4
    .line 5
    .line 6
    move-result-object v1

    .line 7
    iget-object p1, p1, Lg9/j$a;->b:Ln9/g;

    .line 8
    .line 9
    invoke-virtual {p0}, Lg9/j;->n()Li9/k0;

    .line 10
    .line 11
    .line 12
    move-result-object v2

    .line 13
    invoke-direct {v0, v1, p1, v2}, Li9/l;-><init>(Li9/h1;Ln9/g;Li9/k0;)V

    .line 14
    .line 15
    .line 16
    return-object v0
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public e(Lg9/j$a;)Li9/h1;
    .locals 6

    .line 1
    new-instance v4, Li9/p;

    .line 2
    .line 3
    invoke-virtual {p0}, Lg9/j;->p()Lm9/o0;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-direct {v4, v0}, Li9/p;-><init>(Lm9/o0;)V

    .line 8
    .line 9
    .line 10
    iget-object v0, p0, Lg9/j;->a:Lcom/google/firebase/firestore/g;

    .line 11
    .line 12
    invoke-virtual {v0}, Lcom/google/firebase/firestore/g;->g()J

    .line 13
    .line 14
    .line 15
    move-result-wide v0

    .line 16
    invoke-static {v0, v1}, Li9/q0$b;->a(J)Li9/q0$b;

    .line 17
    .line 18
    .line 19
    move-result-object v5

    .line 20
    new-instance v0, Li9/e3;

    .line 21
    .line 22
    iget-object v1, p1, Lg9/j$a;->a:Landroid/content/Context;

    .line 23
    .line 24
    iget-object v2, p1, Lg9/j$a;->c:Lg9/l;

    .line 25
    .line 26
    invoke-virtual {v2}, Lg9/l;->c()Ljava/lang/String;

    .line 27
    .line 28
    .line 29
    move-result-object v2

    .line 30
    iget-object p1, p1, Lg9/j$a;->c:Lg9/l;

    .line 31
    .line 32
    invoke-virtual {p1}, Lg9/l;->a()Lj9/f;

    .line 33
    .line 34
    .line 35
    move-result-object v3

    .line 36
    invoke-direct/range {v0 .. v5}, Li9/e3;-><init>(Landroid/content/Context;Ljava/lang/String;Lj9/f;Li9/p;Li9/q0$b;)V

    .line 37
    .line 38
    .line 39
    return-object v0
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
.end method
