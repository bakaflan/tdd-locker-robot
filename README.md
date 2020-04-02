
# TDD「Locker Robot」

### 箱子存放问题Tasking by Ruiling Guo

正常存包
- Given 有空位置
- When 用户存一个包
- Then 开箱子并返回票据

正常取包
- Given 票据对应一个箱子
- When 用户用票据取包
- Then 开箱子并作废票据

箱子满 存包
- Given 没有空位置
- When 用户存一个包
- Then 提示用户没有位置

票据过期取包
- Given 一个票据过期
- When 用户用票据取包
- Then 提示用户票据过期


### 机器人辅助存包

机器人辅助正常存包
- Given 有柜子存在空位可以存包 
- When 用户将包给机器人并存包
- Then 机器人存包并返回票据

机器人辅助正常取包
- Given  有效票据   
- When 递交票据并取包  
- Then 机器人返回包并作废票据

机器人辅助失败存包
- Given  所有locker已满
- When 递交包并存包  
- Then 机器人返回错误提示没有空位

机器人辅助失败取包
- Given  票据无效   
- When 递交票据并取包  
- Then 机器人返回错误提示票据无效