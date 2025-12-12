Set WshShell = CreateObject("WScript.Shell")
Set FSO = CreateObject("Scripting.FileSystemObject")
Folder = FSO.GetParentFolderName(WScript.ScriptFullName)
WshShell.Run Chr(34) & Folder & "\launch.bat" & Chr(34), 0
Set WshShell = Nothing
Set FSO = Nothing
