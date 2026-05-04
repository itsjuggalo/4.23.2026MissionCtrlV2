.class public final Lb9/a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lb9/a$a;
    }
.end annotation


# instance fields
.field public a:I

.field public b:Lb9/d$a;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    sget-object v0, Lb9/d$a;->a:Lb9/d$a;

    .line 5
    .line 6
    iput-object v0, p0, Lb9/a;->b:Lb9/d$a;

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
.end method

.method public static b()Lb9/a;
    .locals 1

    .line 1
    new-instance v0, Lb9/a;

    .line 2
    .line 3
    invoke-direct {v0}, Lb9/a;-><init>()V

    .line 4
    .line 5
    .line 6
    return-object v0
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
.end method


# virtual methods
.method public a()Lb9/d;
    .locals 3

    .line 1
    new-instance v0, Lb9/a$a;

    .line 2
    .line 3
    iget v1, p0, Lb9/a;->a:I

    .line 4
    .line 5
    iget-object v2, p0, Lb9/a;->b:Lb9/d$a;

    .line 6
    .line 7
    invoke-direct {v0, v1, v2}, Lb9/a$a;-><init>(ILb9/d$a;)V

    .line 8
    .line 9
    .line 10
    return-object v0
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public c(I)Lb9/a;
    .locals 0

    .line 1
    iput p1, p0, Lb9/a;->a:I

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method
