package cryodex.modules.destiny;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import cryodex.modules.TournamentGUI;
import cryodex.widget.RoundTabbedPane;

public class DestinyTournamentGUI implements TournamentGUI {

	private RoundTabbedPane roundTabbedPane;
	private DestinyRankingTable rankingTable;
	private JSplitPane tmentSplitter;
	private JPanel roundPane;
	private JPanel rankingPane;
	private JPanel display;
	private final DestinyTournament tournament;

	public DestinyTournamentGUI(DestinyTournament tournament) {
		this.tournament = tournament;
	}

	public JPanel getDisplay() {
		if (display == null) {
			display = new JPanel(new BorderLayout());

			display.add(getTmentSplitter(), BorderLayout.CENTER);
		}
		return display;
	}

	public RoundTabbedPane getRoundTabbedPane() {
		if (roundTabbedPane == null) {
			roundTabbedPane = new RoundTabbedPane();
		}
		return roundTabbedPane;
	}

	public JSplitPane getTmentSplitter() {
		if (tmentSplitter == null) {
			tmentSplitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
					getRoundPanel(), getRankingPanel());
			tmentSplitter.setResizeWeight(1.0);
		}
		return tmentSplitter;
	}

	public JPanel getRoundPanel() {
		if (roundPane == null) {
			roundPane = new JPanel(new BorderLayout());
			roundPane.add(getRoundTabbedPane(), BorderLayout.CENTER);
		}
		return roundPane;
	}

	public JPanel getRankingPanel() {
		if (rankingPane == null) {
			rankingPane = new JPanel(new BorderLayout());
			rankingPane.add(getRankingTable(), BorderLayout.CENTER);
		}
		return rankingPane;
	}

	public DestinyRankingTable getRankingTable() {
		if (rankingTable == null) {
			rankingTable = new DestinyRankingTable(tournament);
		}
		return rankingTable;
	}

}
