.class public abstract Lna/b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lna/b$b;
    }
.end annotation


# static fields
.field public static final a:Lna/a;

.field public static volatile b:Lna/a;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lna/b$b;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-direct {v0, v1}, Lna/b$b;-><init>(Lna/b$a;)V

    .line 5
    .line 6
    .line 7
    sput-object v0, Lna/b;->a:Lna/a;

    .line 8
    .line 9
    sput-object v0, Lna/b;->b:Lna/a;

    .line 10
    .line 11
    return-void
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public static a()Lna/a;
    .locals 1

    .line 1
    sget-object v0, Lna/b;->b:Lna/a;

    .line 2
    .line 3
    return-object v0
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
.end method
