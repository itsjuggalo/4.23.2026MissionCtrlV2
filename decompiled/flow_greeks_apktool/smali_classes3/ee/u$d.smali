.class public final Lee/u$d;
.super Lhg/b$b;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lee/u;->A(Lfe/z;)Lee/u$a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation


# instance fields
.field public final synthetic a:Ljava/lang/String;

.field public final synthetic b:Lkotlin/jvm/internal/m0;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lkotlin/jvm/internal/m0;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lee/u$d;->a:Ljava/lang/String;

    .line 2
    .line 3
    iput-object p2, p0, Lee/u$d;->b:Lkotlin/jvm/internal/m0;

    .line 4
    .line 5
    invoke-direct {p0}, Lhg/b$b;-><init>()V

    .line 6
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


# virtual methods
.method public bridge synthetic a()Ljava/lang/Object;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lee/u$d;->e()Lee/u$a;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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
.end method

.method public bridge synthetic c(Ljava/lang/Object;)Z
    .locals 0

    .line 1
    check-cast p1, Lfe/e;

    .line 2
    .line 3
    invoke-virtual {p0, p1}, Lee/u$d;->d(Lfe/e;)Z

    .line 4
    .line 5
    .line 6
    move-result p1

    .line 7
    return p1
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
    .line 25
    .line 26
.end method

.method public d(Lfe/e;)Z
    .locals 2

    .line 1
    const-string v0, "javaClassDescriptor"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    sget-object v0, Lxe/f0;->a:Lxe/f0;

    .line 7
    .line 8
    iget-object v1, p0, Lee/u$d;->a:Ljava/lang/String;

    .line 9
    .line 10
    invoke-static {v0, p1, v1}, Lxe/b0;->a(Lxe/f0;Lfe/e;Ljava/lang/String;)Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    move-result-object p1

    .line 14
    sget-object v0, Lee/x;->a:Lee/x;

    .line 15
    .line 16
    invoke-virtual {v0}, Lee/x;->f()Ljava/util/Set;

    .line 17
    .line 18
    .line 19
    move-result-object v1

    .line 20
    invoke-interface {v1, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    .line 21
    .line 22
    .line 23
    move-result v1

    .line 24
    if-eqz v1, :cond_0

    .line 25
    .line 26
    iget-object p1, p0, Lee/u$d;->b:Lkotlin/jvm/internal/m0;

    .line 27
    .line 28
    sget-object v0, Lee/u$a;->a:Lee/u$a;

    .line 29
    .line 30
    iput-object v0, p1, Lkotlin/jvm/internal/m0;->a:Ljava/lang/Object;

    .line 31
    .line 32
    goto :goto_0

    .line 33
    :cond_0
    invoke-virtual {v0}, Lee/x;->i()Ljava/util/Set;

    .line 34
    .line 35
    .line 36
    move-result-object v1

    .line 37
    invoke-interface {v1, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    .line 38
    .line 39
    .line 40
    move-result v1

    .line 41
    if-eqz v1, :cond_1

    .line 42
    .line 43
    iget-object p1, p0, Lee/u$d;->b:Lkotlin/jvm/internal/m0;

    .line 44
    .line 45
    sget-object v0, Lee/u$a;->b:Lee/u$a;

    .line 46
    .line 47
    iput-object v0, p1, Lkotlin/jvm/internal/m0;->a:Ljava/lang/Object;

    .line 48
    .line 49
    goto :goto_0

    .line 50
    :cond_1
    invoke-virtual {v0}, Lee/x;->c()Ljava/util/Set;

    .line 51
    .line 52
    .line 53
    move-result-object v1

    .line 54
    invoke-interface {v1, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    .line 55
    .line 56
    .line 57
    move-result v1

    .line 58
    if-eqz v1, :cond_2

    .line 59
    .line 60
    iget-object p1, p0, Lee/u$d;->b:Lkotlin/jvm/internal/m0;

    .line 61
    .line 62
    sget-object v0, Lee/u$a;->c:Lee/u$a;

    .line 63
    .line 64
    iput-object v0, p1, Lkotlin/jvm/internal/m0;->a:Ljava/lang/Object;

    .line 65
    .line 66
    goto :goto_0

    .line 67
    :cond_2
    invoke-virtual {v0}, Lee/x;->d()Ljava/util/Set;

    .line 68
    .line 69
    .line 70
    move-result-object v0

    .line 71
    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    .line 72
    .line 73
    .line 74
    move-result p1

    .line 75
    if-eqz p1, :cond_3

    .line 76
    .line 77
    iget-object p1, p0, Lee/u$d;->b:Lkotlin/jvm/internal/m0;

    .line 78
    .line 79
    sget-object v0, Lee/u$a;->e:Lee/u$a;

    .line 80
    .line 81
    iput-object v0, p1, Lkotlin/jvm/internal/m0;->a:Ljava/lang/Object;

    .line 82
    .line 83
    :cond_3
    :goto_0
    iget-object p1, p0, Lee/u$d;->b:Lkotlin/jvm/internal/m0;

    .line 84
    .line 85
    iget-object p1, p1, Lkotlin/jvm/internal/m0;->a:Ljava/lang/Object;

    .line 86
    .line 87
    if-nez p1, :cond_4

    .line 88
    .line 89
    const/4 p1, 0x1

    .line 90
    return p1

    .line 91
    :cond_4
    const/4 p1, 0x0

    .line 92
    return p1
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
.end method

.method public e()Lee/u$a;
    .locals 1

    .line 1
    iget-object v0, p0, Lee/u$d;->b:Lkotlin/jvm/internal/m0;

    .line 2
    .line 3
    iget-object v0, v0, Lkotlin/jvm/internal/m0;->a:Ljava/lang/Object;

    .line 4
    .line 5
    check-cast v0, Lee/u$a;

    .line 6
    .line 7
    if-nez v0, :cond_0

    .line 8
    .line 9
    sget-object v0, Lee/u$a;->d:Lee/u$a;

    .line 10
    .line 11
    :cond_0
    return-object v0
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method
