
package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface que define o contrato para todos os navios no jogo da Batalha Naval.
 * Especifica os métodos necessários para gerir as propriedades, estado e
 * localização espacial de uma embarcação no tabuleiro.
 */
public interface IShip {
    
    /**
     * Obtém a categoria do navio (por exemplo, "barca", "caravela", "nau", "fragata" ou "galeao").
     *
     * @return uma String que representa a categoria do navio.
     */
    String getCategory();

    /**
     * Obtém o tamanho do navio, ou seja, o número total de quadrículas que este ocupa.
     *
     * @return o número de posições ocupadas pelo navio.
     */
    Integer getSize();

    /**
     * Obtém a lista de todas as posições exatas que o navio ocupa no tabuleiro.
     *
     * @return uma lista de objetos do tipo {@link IPosition} correspondentes ao corpo do navio.
     */
    List<IPosition> getPositions();

    /**
     * Obtém a posição de referência (ponto de origem/ancoragem) usada para criar o navio.
     *
     * @return a posição inicial do navio do tipo {@link IPosition}.
     */
    IPosition getPosition();

    /**
     * Obtém a orientação geográfica do navio no tabuleiro.
     *
     * @return a direção do navio representada pelo enumerado {@link Compass} (Norte, Sul, Este, Oeste).
     */
    Compass getBearing();

    /**
     * Verifica se o navio ainda está a flutuar. Um navio flutua desde que tenha
     * pelo menos uma posição que ainda não foi atingida por um tiro.
     *
     * @return true se o navio tiver partes intactas, false se estiver totalmente afundado.
     */
    boolean stillFloating();

    /**
     * Obtém o índice da linha mais acima (menor valor numérico de linha) ocupada pelo navio.
     *
     * @return o valor da linha superior.
     */
    int getTopMostPos();

    /**
     * Obtém o índice da linha mais abaixo (maior valor numérico de linha) ocupada pelo navio.
     *
     * @return o valor da linha inferior.
     */
    int getBottomMostPos();
    
    /**
     * Obtém o índice da coluna mais à esquerda (menor valor numérico de coluna) ocupada pelo navio.
     *
     * @return o valor da coluna à esquerda.
     */
    int getLeftMostPos();

    /**
     * Obtém o índice da coluna mais à direita (maior valor numérico de coluna) ocupada pelo navio.
     *
     * @return o valor da coluna à direita.
     */
    int getRightMostPos();

    /**
     * Verifica se o navio ocupa uma coordenada específica no tabuleiro.
     *
     * @param pos a posição a ser verificada.
     * @return true se a posição fizer parte do corpo do navio, false caso contrário.
     */
    boolean occupies(IPosition pos);

    /**
     * Verifica se este navio está demasiado perto de outro navio, violando as regras
     * de colocação (navios não se podem tocar ortogonalmente nem na diagonal).
     *
     * @param other o outro navio a ser comparado.
     * @return true se os navios estiverem adjacentes ou sobrepostos, false caso contrário.
     */
    boolean tooCloseTo(IShip other);

    /**
     * Verifica se este navio está demasiado perto (adjacente ou sobreposto) de uma
     * posição específica no tabuleiro.
     *
     * @param pos a posição a ser comparada com as posições do navio.
     * @return true se a posição estiver a tocar ou a sobrepor-se ao navio, false caso contrário.
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Regista um disparo sobre o navio numa posição específica. Se a posição indicada
     * coincidir com uma das posições ocupadas pelo navio, o estado dessa parte passa a atingido.
     *
     * @param pos a coordenada para onde o tiro foi disparado.
     */
    void shoot(IPosition pos);
}
