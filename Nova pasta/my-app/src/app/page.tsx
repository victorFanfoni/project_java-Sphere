import { Button } from "@/components/ui/button";
import { ModeToggle } from "@/components/ui/mode-toggle";
import Image from "next/image";

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <nav className= "absolute rigth-2 top-2">
      <ModeToggle/>
      </nav>
      
      <h1>Exercicio</h1>
      <Button>entrar</Button>
    </main>
  );
}
