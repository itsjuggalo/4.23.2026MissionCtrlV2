.class public Ltb/e2$c;
.super Lrb/b1$d;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/e2;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "c"
.end annotation


# instance fields
.field public a:Lrb/b1$d;

.field public final synthetic b:Ltb/e2;


# direct methods
.method public constructor <init>(Ltb/e2;Lrb/b1$d;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/e2$c;->b:Ltb/e2;

    .line 2
    .line 3
    invoke-direct {p0}, Lrb/b1$d;-><init>()V

    .line 4
    .line 5
    .line 6
    iput-object p2, p0, Ltb/e2$c;->a:Lrb/b1$d;

    .line 7
    .line 8
    return-void
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
    .line 25
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
.end method

.method public static synthetic c(Ltb/e2$c;)V
    .locals 2

    .line 1
    iget-object v0, p0, Ltb/e2$c;->b:Ltb/e2;

    .line 2
    .line 3
    invoke-static {v0}, Ltb/e2;->f(Ltb/e2;)Ltb/d2;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    new-instance v1, Ltb/e2$a;

    .line 8
    .line 9
    iget-object p0, p0, Ltb/e2$c;->b:Ltb/e2;

    .line 10
    .line 11
    invoke-direct {v1, p0}, Ltb/e2$a;-><init>(Ltb/e2;)V

    .line 12
    .line 13
    .line 14
    invoke-interface {v0, v1}, Ltb/d2;->a(Ljava/lang/Runnable;)V

    .line 15
    .line 16
    .line 17
    return-void
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method


# virtual methods
.method public a(Lrb/k1;)V
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/e2$c;->a:Lrb/b1$d;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lrb/b1$d;->a(Lrb/k1;)V

    .line 4
    .line 5
    .line 6
    iget-object p1, p0, Ltb/e2$c;->b:Ltb/e2;

    .line 7
    .line 8
    invoke-static {p1}, Ltb/e2;->e(Ltb/e2;)Lrb/o1;

    .line 9
    .line 10
    .line 11
    move-result-object p1

    .line 12
    new-instance v0, Ltb/f2;

    .line 13
    .line 14
    invoke-direct {v0, p0}, Ltb/f2;-><init>(Ltb/e2$c;)V

    .line 15
    .line 16
    .line 17
    invoke-virtual {p1, v0}, Lrb/o1;->execute(Ljava/lang/Runnable;)V

    .line 18
    .line 19
    .line 20
    return-void
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public b(Lrb/b1$e;)V
    .locals 5

    .line 1
    invoke-virtual {p1}, Lrb/b1$e;->b()Lrb/a;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    sget-object v1, Ltb/e2;->e:Lrb/a$c;

    .line 6
    .line 7
    invoke-virtual {v0, v1}, Lrb/a;->b(Lrb/a$c;)Ljava/lang/Object;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    if-nez v0, :cond_0

    .line 12
    .line 13
    iget-object v0, p0, Ltb/e2$c;->a:Lrb/b1$d;

    .line 14
    .line 15
    invoke-virtual {p1}, Lrb/b1$e;->e()Lrb/b1$e$a;

    .line 16
    .line 17
    .line 18
    move-result-object v2

    .line 19
    invoke-virtual {p1}, Lrb/b1$e;->b()Lrb/a;

    .line 20
    .line 21
    .line 22
    move-result-object p1

    .line 23
    invoke-virtual {p1}, Lrb/a;->d()Lrb/a$b;

    .line 24
    .line 25
    .line 26
    move-result-object p1

    .line 27
    new-instance v3, Ltb/e2$b;

    .line 28
    .line 29
    iget-object v4, p0, Ltb/e2$c;->b:Ltb/e2;

    .line 30
    .line 31
    invoke-direct {v3, v4}, Ltb/e2$b;-><init>(Ltb/e2;)V

    .line 32
    .line 33
    .line 34
    invoke-virtual {p1, v1, v3}, Lrb/a$b;->d(Lrb/a$c;Ljava/lang/Object;)Lrb/a$b;

    .line 35
    .line 36
    .line 37
    move-result-object p1

    .line 38
    invoke-virtual {p1}, Lrb/a$b;->a()Lrb/a;

    .line 39
    .line 40
    .line 41
    move-result-object p1

    .line 42
    invoke-virtual {v2, p1}, Lrb/b1$e$a;->c(Lrb/a;)Lrb/b1$e$a;

    .line 43
    .line 44
    .line 45
    move-result-object p1

    .line 46
    invoke-virtual {p1}, Lrb/b1$e$a;->a()Lrb/b1$e;

    .line 47
    .line 48
    .line 49
    move-result-object p1

    .line 50
    invoke-virtual {v0, p1}, Lrb/b1$d;->b(Lrb/b1$e;)V

    .line 51
    .line 52
    .line 53
    return-void

    .line 54
    :cond_0
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 55
    .line 56
    const-string v0, "RetryingNameResolver can only be used once to wrap a NameResolver"

    .line 57
    .line 58
    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 59
    .line 60
    .line 61
    throw p1
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
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
.end method
