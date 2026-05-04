.class public final Lpc/u;
.super Lcc/j;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lpc/u$a;,
        Lpc/u$c;,
        Lpc/u$b;
    }
.end annotation


# instance fields
.field public final a:[Lcc/n;

.field public final b:Lic/e;


# direct methods
.method public constructor <init>([Lcc/n;Lic/e;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcc/j;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lpc/u;->a:[Lcc/n;

    .line 5
    .line 6
    iput-object p2, p0, Lpc/u;->b:Lic/e;

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
.method public u(Lcc/l;)V
    .locals 5

    .line 1
    iget-object v0, p0, Lpc/u;->a:[Lcc/n;

    .line 2
    .line 3
    array-length v1, v0

    .line 4
    const/4 v2, 0x1

    .line 5
    const/4 v3, 0x0

    .line 6
    if-ne v1, v2, :cond_0

    .line 7
    .line 8
    aget-object v0, v0, v3

    .line 9
    .line 10
    new-instance v1, Lpc/n$a;

    .line 11
    .line 12
    new-instance v2, Lpc/u$a;

    .line 13
    .line 14
    invoke-direct {v2, p0}, Lpc/u$a;-><init>(Lpc/u;)V

    .line 15
    .line 16
    .line 17
    invoke-direct {v1, p1, v2}, Lpc/n$a;-><init>(Lcc/l;Lic/e;)V

    .line 18
    .line 19
    .line 20
    invoke-interface {v0, v1}, Lcc/n;->a(Lcc/l;)V

    .line 21
    .line 22
    .line 23
    return-void

    .line 24
    :cond_0
    new-instance v2, Lpc/u$b;

    .line 25
    .line 26
    iget-object v4, p0, Lpc/u;->b:Lic/e;

    .line 27
    .line 28
    invoke-direct {v2, p1, v1, v4}, Lpc/u$b;-><init>(Lcc/l;ILic/e;)V

    .line 29
    .line 30
    .line 31
    invoke-interface {p1, v2}, Lcc/l;->a(Lfc/b;)V

    .line 32
    .line 33
    .line 34
    :goto_0
    if-ge v3, v1, :cond_3

    .line 35
    .line 36
    invoke-virtual {v2}, Lpc/u$b;->c()Z

    .line 37
    .line 38
    .line 39
    move-result p1

    .line 40
    if-eqz p1, :cond_1

    .line 41
    .line 42
    goto :goto_1

    .line 43
    :cond_1
    aget-object p1, v0, v3

    .line 44
    .line 45
    if-nez p1, :cond_2

    .line 46
    .line 47
    new-instance p1, Ljava/lang/NullPointerException;

    .line 48
    .line 49
    const-string v0, "One of the sources is null"

    .line 50
    .line 51
    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    .line 52
    .line 53
    .line 54
    invoke-virtual {v2, p1, v3}, Lpc/u$b;->d(Ljava/lang/Throwable;I)V

    .line 55
    .line 56
    .line 57
    return-void

    .line 58
    :cond_2
    iget-object v4, v2, Lpc/u$b;->c:[Lpc/u$c;

    .line 59
    .line 60
    aget-object v4, v4, v3

    .line 61
    .line 62
    invoke-interface {p1, v4}, Lcc/n;->a(Lcc/l;)V

    .line 63
    .line 64
    .line 65
    add-int/lit8 v3, v3, 0x1

    .line 66
    .line 67
    goto :goto_0

    .line 68
    :cond_3
    :goto_1
    return-void
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
