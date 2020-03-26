
# TDD「Locker Robot」

### 箱子存放问题Tasking by Ruiling Guo

正常存包
- Given 用户存一个包
- When 有空位置
- Then 开箱子并返回票据

正常取包
- Given 用户用票据取包
- When 票据对应一个箱子
- Then 开箱子并作废票据

箱子满 存包
- Given 用户存一个包
- When 没有空位置
- Then 提示用户没有位置

票据过期取包
- Given 用户用票据取包
- When 这个票据过期
- Then 提示用户票据过期


