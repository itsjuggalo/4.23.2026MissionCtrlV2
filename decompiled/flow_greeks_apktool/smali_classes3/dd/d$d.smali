.class public final Ldd/d$d;
.super Ldd/d;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/util/RandomAccess;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ldd/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "d"
.end annotation


# instance fields
.field public final b:Ldd/d;

.field public final c:I

.field public d:I


# direct methods
.method public constructor <init>(Ldd/d;II)V
    .locals 1

    .line 1
    const-string v0, "list"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    invoke-direct {p0}, Ldd/d;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object p1, p0, Ldd/d$d;->b:Ldd/d;

    .line 10
    .line 11
    iput p2, p0, Ldd/d$d;->c:I

    .line 12
    .line 13
    sget-object v0, Ldd/d;->a:Ldd/d$a;

    .line 14
    .line 15
    invoke-virtual {p1}, Ldd/b;->size()I

    .line 16
    .line 17
    .line 18
    move-result p1

    .line 19
    invoke-virtual {v0, p2, p3, p1}, Ldd/d$a;->d(III)V

    .line 20
    .line 21
    .line 22
    sub-int/2addr p3, p2

    .line 23
    iput p3, p0, Ldd/d$d;->d:I

    .line 24
    .line 25
    return-void
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
.end method


# virtual methods
.method public c()I
    .locals 1

    .line 1
    iget v0, p0, Ldd/d$d;->d:I

    .line 2
    .line 3
    return v0
    .line 4
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
.end method

.method public get(I)Ljava/lang/Object;
    .locals 2

    .line 1
    sget-object v0, Ldd/d;->a:Ldd/d$a;

    .line 2
    .line 3
    iget v1, p0, Ldd/d$d;->d:I

    .line 4
    .line 5
    invoke-virtual {v0, p1, v1}, Ldd/d$a;->b(II)V

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Ldd/d$d;->b:Ldd/d;

    .line 9
    .line 10
    iget v1, p0, Ldd/d$d;->c:I

    .line 11
    .line 12
    add-int/2addr v1, p1

    .line 13
    invoke-virtual {v0, v1}, Ldd/d;->get(I)Ljava/lang/Object;

    .line 14
    .line 15
    .line 16
    move-result-object p1

    .line 17
    return-object p1
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

.method public subList(II)Ljava/util/List;
    .locals 3

    .line 1
    sget-object v0, Ldd/d;->a:Ldd/d$a;

    .line 2
    .line 3
    iget v1, p0, Ldd/d$d;->d:I

    .line 4
    .line 5
    invoke-virtual {v0, p1, p2, v1}, Ldd/d$a;->d(III)V

    .line 6
    .line 7
    .line 8
    new-instance v0, Ldd/d$d;

    .line 9
    .line 10
    iget-object v1, p0, Ldd/d$d;->b:Ldd/d;

    .line 11
    .line 12
    iget v2, p0, Ldd/d$d;->c:I

    .line 13
    .line 14
    add-int/2addr p1, v2

    .line 15
    add-int/2addr v2, p2

    .line 16
    invoke-direct {v0, v1, p1, v2}, Ldd/d$d;-><init>(Ldd/d;II)V

    .line 17
    .line 18
    .line 19
    return-object v0
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
