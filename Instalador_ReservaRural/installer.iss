; -- Información básica del instalador --
[Setup]
AppName=Reserva Rural App
AppVersion=1.0
DefaultDirName={pf}\ReservaRuralApp
DefaultGroupName=Reserva Rural App
OutputDir=.
OutputBaseFilename=ReservaRuralInstalador
AllowNoIcons=yes
SetupIconFile=icono.ico
UninstallDisplayIcon={app}\icono.ico
Compression=lzma
SolidCompression=yes

; -- Archivos a incluir --
[Files]
Source: "casas-1.0-SNAPSHOT-shaded.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "reservas_rurales.db"; DestDir: "{app}"; Flags: ignoreversion
Source: "icono.ico"; DestDir: "{app}"; Flags: ignoreversion
Source: "jre\*"; DestDir: "{app}\jre"; Flags: recursesubdirs ignoreversion
Source: "launch.bat"; DestDir: "{app}"; Flags: ignoreversion
Source: "launch.vbs"; DestDir: "{app}"; Flags: ignoreversion

; -- Tareas opcionales para el usuario --
[Tasks]
Name: desktopicon; Description: "Crear acceso directo en el escritorio"; GroupDescription: "Opciones adicionales"; Flags: unchecked

; -- Crear accesos directos --
[Icons]
Name: "{group}\Reserva Rural App"; Filename: "{app}\launch.vbs"; IconFilename: "{app}\icono.ico"
Name: "{userdesktop}\Reserva Rural App"; Filename: "{app}\launch.vbs"; IconFilename: "{app}\icono.ico"; Tasks: desktopicon

; -- Desinstalación --
[UninstallDelete]
Type: filesandordirs; Name: "{app}"
