.class public final Lre/g;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lge/h;


# instance fields
.field public final a:Lre/k;

.field public final b:Lve/d;

.field public final c:Z

.field public final d:Lwf/h;


# direct methods
.method public constructor <init>(Lre/k;Lve/d;Z)V
    .locals 1

    const-string v0, "c"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "annotationOwner"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput-object p1, p0, Lre/g;->a:Lre/k;

    .line 3
    iput-object p2, p0, Lre/g;->b:Lve/d;

    .line 4
    iput-boolean p3, p0, Lre/g;->c:Z

    .line 5
    invoke-virtual {p1}, Lre/k;->a()Lre/d;

    move-result-object p1

    invoke-virtual {p1}, Lre/d;->u()Lwf/n;

    move-result-object p1

    new-instance p2, Lre/f;

    invoke-direct {p2, p0}, Lre/f;-><init>(Lre/g;)V

    invoke-interface {p1, p2}, Lwf/n;->h(Lpd/k;)Lwf/h;

    move-result-object p1

    iput-object p1, p0, Lre/g;->d:Lwf/h;

    return-void
.end method

.method public synthetic constructor <init>(Lre/k;Lve/d;ZILkotlin/jvm/internal/k;)V
    .locals 0

    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_0

    const/4 p3, 0x0

    .line 6
    :cond_0
    invoke-direct {p0, p1, p2, p3}, Lre/g;-><init>(Lre/k;Lve/d;Z)V

    return-void
.end method

.method public static synthetic a(Lre/g;Lve/a;)Lge/c;
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lre/g;->c(Lre/g;Lve/a;)Lge/c;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    return-object p0
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

.method public static final c(Lre/g;Lve/a;)Lge/c;
    .locals 2

    .line 1
    const-string v0, "annotation"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    sget-object v0, Lpe/d;->a:Lpe/d;

    .line 7
    .line 8
    iget-object v1, p0, Lre/g;->a:Lre/k;

    .line 9
    .line 10
    iget-boolean p0, p0, Lre/g;->c:Z

    .line 11
    .line 12
    invoke-virtual {v0, p1, v1, p0}, Lpe/d;->e(Lve/a;Lre/k;Z)Lge/c;

    .line 13
    .line 14
    .line 15
    move-result-object p0

    .line 16
    return-object p0
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
.method public E(Lef/c;)Z
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lge/h$b;->b(Lge/h;Lef/c;)Z

    .line 2
    .line 3
    .line 4
    move-result p1

    .line 5
    return p1
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
    .line 25
    .line 26
.end method

.method public b(Lef/c;)Lge/c;
    .locals 3

    .line 1
    const-string v0, "fqName"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lre/g;->b:Lve/d;

    .line 7
    .line 8
    invoke-interface {v0, p1}, Lve/d;->b(Lef/c;)Lve/a;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    if-eqz v0, :cond_1

    .line 13
    .line 14
    iget-object v1, p0, Lre/g;->d:Lwf/h;

    .line 15
    .line 16
    invoke-interface {v1, v0}, Lpd/k;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    .line 17
    .line 18
    .line 19
    move-result-object v0

    .line 20
    check-cast v0, Lge/c;

    .line 21
    .line 22
    if-nez v0, :cond_0

    .line 23
    .line 24
    goto :goto_0

    .line 25
    :cond_0
    return-object v0

    .line 26
    :cond_1
    :goto_0
    sget-object v0, Lpe/d;->a:Lpe/d;

    .line 27
    .line 28
    iget-object v1, p0, Lre/g;->b:Lve/d;

    .line 29
    .line 30
    iget-object v2, p0, Lre/g;->a:Lre/k;

    .line 31
    .line 32
    invoke-virtual {v0, p1, v1, v2}, Lpe/d;->a(Lef/c;Lve/d;Lre/k;)Lge/c;

    .line 33
    .line 34
    .line 35
    move-result-object p1

    .line 36
    return-object p1
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

.method public isEmpty()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lre/g;->b:Lve/d;

    .line 2
    .line 3
    invoke-interface {v0}, Lve/d;->getAnnotations()Ljava/util/Collection;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-interface {v0}, Ljava/util/Collection;->isEmpty()Z

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    if-eqz v0, :cond_0

    .line 12
    .line 13
    iget-object v0, p0, Lre/g;->b:Lve/d;

    .line 14
    .line 15
    invoke-interface {v0}, Lve/d;->n()Z

    .line 16
    .line 17
    .line 18
    move-result v0

    .line 19
    if-nez v0, :cond_0

    .line 20
    .line 21
    const/4 v0, 0x1

    .line 22
    return v0

    .line 23
    :cond_0
    const/4 v0, 0x0

    .line 24
    return v0
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
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 5

    .line 1
    iget-object v0, p0, Lre/g;->b:Lve/d;

    .line 2
    .line 3
    invoke-interface {v0}, Lve/d;->getAnnotations()Ljava/util/Collection;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-static {v0}, Ldd/a0;->Q(Ljava/lang/Iterable;)Ljg/h;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    iget-object v1, p0, Lre/g;->d:Lwf/h;

    .line 12
    .line 13
    invoke-static {v0, v1}, Ljg/t;->E(Ljg/h;Lpd/k;)Ljg/h;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    sget-object v1, Lpe/d;->a:Lpe/d;

    .line 18
    .line 19
    sget-object v2, Lce/o$a;->y:Lef/c;

    .line 20
    .line 21
    iget-object v3, p0, Lre/g;->b:Lve/d;

    .line 22
    .line 23
    iget-object v4, p0, Lre/g;->a:Lre/k;

    .line 24
    .line 25
    invoke-virtual {v1, v2, v3, v4}, Lpe/d;->a(Lef/c;Lve/d;Lre/k;)Lge/c;

    .line 26
    .line 27
    .line 28
    move-result-object v1

    .line 29
    invoke-static {v0, v1}, Ljg/t;->H(Ljg/h;Ljava/lang/Object;)Ljg/h;

    .line 30
    .line 31
    .line 32
    move-result-object v0

    .line 33
    invoke-static {v0}, Ljg/t;->z(Ljg/h;)Ljg/h;

    .line 34
    .line 35
    .line 36
    move-result-object v0

    .line 37
    invoke-interface {v0}, Ljg/h;->iterator()Ljava/util/Iterator;

    .line 38
    .line 39
    .line 40
    move-result-object v0

    .line 41
    return-object v0
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
.end method
